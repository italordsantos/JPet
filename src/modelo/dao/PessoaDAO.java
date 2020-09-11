/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;

/**
 *
 * @author Rafael
 */
public class PessoaDAO {

    private final String SQLBASE_PESQUISAR
            = "SELECT p.*, c.nome as c_cidade_nome, e.sigla "
            + "FROM public.pessoa as p "
            + "JOIN cidade c "
            + "ON p.cidade_id = c.id "
            + "JOIN estado e "
            + "on e.id = c.estado_id ";

    /**
     * Insere uma pessoa no banco
     *
     * @param pessoa pessoa que será inserida. O id é gerado automaticamente.
     * @return retorna verdadeiro caso inserido com sucesso
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected boolean inserir(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        String sql = "insert into pessoa "
                + "(nome, data_nascimento, endereco, "
                + "numero, bairro, cidade_id, registro_ativo) "
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);
        consulta.setString(1, pessoa.getNome());
        consulta.setDate(2, new Date(pessoa.getDataNascimento().getTime()));
        consulta.setString(3, pessoa.getEndereco());
        consulta.setInt(4, pessoa.getNumero());
        consulta.setString(5, pessoa.getBairro());
        consulta.setInt(6, pessoa.getCidade().getId());
        consulta.setBoolean(7, pessoa.isAtivo());

        return consulta.executeUpdate() == 1;
    }

    /**
     * Altera todos os dados da pessoa, exceto o id. Caso precise alterar este,
     * o mesmo precisa ser feito diretamente no banco. É necessário que o campo
     * id esteja preenchido para que o método funcione.
     *
     * @param pessoa pessoa no qual será alterada
     * @return retorna verdadeiro caso alterado com sucesso
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected boolean alterar(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        String sql = "update pessoa set "
                + "nome = ?, data_nascimento = ?, endereco = ?, "
                + "numero = ?, bairro = ?, cidade_id = ?, registro_ativo = ? "
                + "where id = ? ";

        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);

        consulta.setString(1, pessoa.getNome());
        consulta.setDate(2,
                new java.sql.Date(pessoa.getDataNascimento().getTime()));
        consulta.setString(3, pessoa.getEndereco());
        consulta.setInt(4, pessoa.getNumero());
        consulta.setString(5, pessoa.getBairro());
        consulta.setInt(6, pessoa.getCidade().getId());
        consulta.setBoolean(7, pessoa.isAtivo());
        consulta.setInt(8, pessoa.getId());

        return consulta.executeUpdate() == 1;
    }

    /**
     * Atribui False ao atributo RegistroAtivo do banco. Caso queira excluir de
     * fato, o que não é recomendado, utilize o método ExcluirDefinitivo.
     *
     * @param id id da pessoa que será "excluída" (inativada, propriamente dito)
     * @return retorna true caso seja excluído com sucesso
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected boolean excluir(int id) throws SQLException, ClassNotFoundException {
        return excluirOuReativarCadastro(false, id);
    }

    /**
     * USO NÃO RECOMENDADO. Exclui, de fato, o registro do banco
     *
     * @param id id da pessoa no qual será excluída
     * @return retorna verdadeiro caso excluído com sucesso
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected boolean excluirDefinitivo(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from pessoa where id = ?";

        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);

        consulta.setInt(1, id);

        return consulta.executeUpdate() == 1;
    }

    /**
     * Reativa um cadastro do banco
     *
     * @param id id da pessoa no qual será reativada
     * @return retorna verdadeiro caso consiga reativar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected boolean reativarCadastro(int id) throws SQLException, ClassNotFoundException {
        return excluirOuReativarCadastro(true, id);
    }

    /**
     * Lista todas as pessoas ativas do banco
     *
     * @return retorna os registros encontrados
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected ArrayList<Pessoa> listarPessoas() throws SQLException, ClassNotFoundException {
        return listarPessoas(true);
    }

    /**
     * Possibilita buscar os registros que estão ativos, ou não, no banco
     *
     * @param registro_ativo representa se os dados buscados serão ativos ou não
     * @return retornará os registros com base no parâmetro @registro_ativo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected ArrayList<Pessoa> listarPessoas(boolean registro_ativo) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.preparedStatement(
                SQLBASE_PESQUISAR
                + "where p.registro_ativo = ? "
                + "order by p.id asc"
        );

        ps.setBoolean(1, registro_ativo);

        return montarPesquisaPessoas(ps.executeQuery());
    }

    /**
     * Faz a pesquisa de pessoas que possuem um determinado termo no nome,
     * podendo estar no começo, meio, ou fim.
     *
     * @param nome termo a ser utilizado na busca
     * @return retorna uma lista de pessoas que possuem este termo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected ArrayList<Pessoa> pesquisarNome(String nome) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.preparedStatement(
                SQLBASE_PESQUISAR
                + "where p.nome like ? and "
                + "p.registro_ativo = ?"
                + "order by p.id asc"
        );
        ps.setString(1, "%" + nome + "%");
        ps.setBoolean(2, true);

        return montarPesquisaPessoas(ps.executeQuery());
    }

    /**
     * Faz a pesquisa de uma pessoa com base em seu id
     *
     * @param id id utilizado na busca
     * @return retornará a pessoa caso encontrado, senão, retornará null
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected Pessoa pesquisarId(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = Conexao.preparedStatement(
                SQLBASE_PESQUISAR
                + "where p.id = ? and "
                + "p.registro_ativo = ? "
                + "order by p.id "
        );
        ps.setInt(1, id);
        ps.setBoolean(2, true);

        return montarPesquisaPessoa(ps.executeQuery());
    }

    /**
     * Método utilizado para reaproveitar código tanto do Excluir quanto do
     * ReativarCadastro. Ele irá alterar a propriedade RegistroAtivo.
     *
     * @param bool variável utilizada para definir se o registro está ativo ou
     * não
     * @param id id utilizado na busca da pessoa
     * @return retornará true caso a operação seja realizado com sucesso
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private boolean excluirOuReativarCadastro(boolean bool, int id) throws ClassNotFoundException, SQLException {
        String sql = "update pessoa set "
                + "registro_ativo = ? "
                + "where id = ? ";

        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);

        consulta.setBoolean(1, bool);
        consulta.setInt(2, id);

        return consulta.executeUpdate() == 1;
    }

    private Pessoa montarPesquisaPessoa(ResultSet rs) throws SQLException {
        Pessoa pessoa = null;
        Cidade cidade;
        Estado estado;

        if (rs.next()) {
            pessoa = new Pessoa();
            cidade = new Cidade();
            estado = new Estado();

            pessoa.setAtivo(rs.getBoolean("registro_ativo"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setDataNascimento(new Date(rs.getDate("data_nascimento").getTime()));
            pessoa.setEndereco(rs.getString("endereco"));
            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setNumero(rs.getInt("numero"));
            pessoa.setCidade(cidade);
            cidade.setEstado(estado);

            cidade.setNome(rs.getString("c_cidade_nome"));

            estado.setSigla(rs.getString("sigla"));
        }

        return pessoa;
    }

    private ArrayList<Pessoa> montarPesquisaPessoas(ResultSet rs) throws SQLException {
        ArrayList<Pessoa> listaPessoa = new ArrayList<>();

        while (!rs.isLast()) {
            listaPessoa.add(montarPesquisaPessoa(rs));
        }

        return listaPessoa;
    }

    /**
     * Este método retorna o próximo ID da sequência de Pessoa, garantindo
     * unicidade. Vale ressaltar que um ID não pode ser compartilhado por mais
     * de uma pessoa.
     *
     * @return retorna o próximo ID da sequência de pessoa no banco
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private int nextVal() throws ClassNotFoundException, SQLException {
        return Conexao.getConexao().prepareStatement("select nextval(pessoa_id_seq)").executeQuery().getInt("pessoa_id_seq");
    }
    
    
    private void teste(Pessoa pessoa) {
        pessoa.getClass().get
    }
}
