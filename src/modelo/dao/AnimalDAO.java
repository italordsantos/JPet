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
import modelo.Animal;
import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;
import modelo.Animal;

/**
 *
 * @author Rafael
 */
public class AnimalDAO {

//    /**
//     * Insere um animal no banco
//     *
//     * @param animal animal que será inserido. O id é gerado automaticamente.
//     * @return retorna verdadeiro caso inserido com sucesso
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    protected boolean inserir(Animal animal) throws ClassNotFoundException, SQLException {
//        String sql = "insert into animal "
//                + "(nome, pessoa_id, registro_ativo) "
//                + "values "
//                + "(?, ?, ?)";
//
//        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);
//        consulta.setString(1, animal.getNome());
//        consulta.setInt(2, animal.getDono().getId());
//        consulta.setBoolean(3, animal.isAtivo());
//
//        return consulta.executeUpdate() == 1;
//    }
//
//    /**
//     * Altera todos os dados de animal, exceto o id. Caso precise alterar este,
//     * o mesmo precisa ser feito diretamente no banco. É necessário que o campo
//     * id esteja preenchido para que o método funcione.
//     *
//     * @param animal animal no qual será alterado
//     * @return retorna verdadeiro caso alterado com sucesso
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    protected boolean alterar(Animal animal) throws ClassNotFoundException, SQLException {
//        String sql = "update pessoa set "
//                + "nome = ?, pessoa_id = ?, registro_ativo = ? "
//                + "where id = ? ";
//
//        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);
//
//        consulta.setString(1, animal.getNome());
//        consulta.setInt(2, animal.getDono().getId());
//        consulta.setBoolean(3, animal.isAtivo());
//        consulta.setInt(4, animal.getId());
//
//        return consulta.executeUpdate() == 1;
//    }
//
//    /**
//     * Atribui False ao atributo RegistroAtivo do banco. Caso queira excluir de
//     * fato, o que não é recomendado, utilize o método ExcluirDefinitivo.
//     *
//     * @param id id do animal que será "excluída" (inativado, propriamente dito)
//     * @return retorna true caso seja excluído com sucesso
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    protected boolean excluir(int id) throws SQLException, ClassNotFoundException {
//        return excluirOuReativarCadastro(false, id);
//    }
//
//    /**
//     * USO NÃO RECOMENDADO. Exclui, de fato, o registro do banco
//     *
//     * @param id id do animal no qual será excluído
//     * @return retorna verdadeiro caso excluído com sucesso
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    protected boolean excluirDefinitivo(int id) throws ClassNotFoundException, SQLException {
//        String sql = "delete from animal where id = ?";
//
//        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);
//
//        consulta.setInt(1, id);
//
//        return consulta.executeUpdate() == 1;
//    }
//
//    /**
//     * Reativa um cadastro do banco
//     *
//     * @param id id da pessoa no qual será reativada
//     * @return retorna verdadeiro caso consiga reativar
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    protected boolean reativarCadastro(int id) throws SQLException, ClassNotFoundException {
//        return excluirOuReativarCadastro(true, id);
//    }
//
//    /**
//     * Lista todos os animais ativos do banco
//     *
//     * @return retorna os registros encontrados
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    protected ArrayList<Animal> listarAnimais() throws SQLException, ClassNotFoundException {
//        return listarAnimais(true);
//    }
//
//    /**
//     * Possibilita buscar os registros que estão ativos, ou não, no banco
//     *
//     * @param registro_ativo representa se os dados buscados serão ativos ou não
//     * @return retornará os registros com base no parâmetro @registro_ativo
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    protected ArrayList<Animal> listarAnimais(boolean registro_ativo) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT a.*, p.nome pnome "
//                + "	FROM public.animal a "
//                + "JOIN "
//                + "	public.pessoa p "
//                + "ON "
//                + "	a.pessoa_id = p.id "
//                + "WHERE "
//                + "     p"
//                + "ORDER BY "
//                + "	a.id ASC; ";
//
//        ArrayList<Animal> listaanimals = new ArrayList<>();
//        Animal animal;
//        Pessoa dono;
//
//        PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
//        statement.setBoolean(1, registro_ativo);
//        ResultSet resultado = statement.executeQuery();
//
//        while (resultado.next()) {
//            animal = new Animal();
//            dono = new Pessoa();
//
//            animal.setAtivo(resultado.getBoolean("registro_ativo"));
//            animal.setId(resultado.getInt("id"));
//            animal.setNome(resultado.getString("nome"));
//            animal.setDono(dono);
//            
//        }
//
//        for (int i = 0; i < 10; i++) {
//            
//        }
//        
//        listarAnimais().forEach((animall) -> {
//            
//        });
//        return listaanimals;
//    }
//
//    /**
//     * Faz a pesquisa de pessoas que possuem um determinado termo no nome,
//     * podendo estar no começo, meio, ou fim.
//     *
//     * @param nome termo a ser utilizado na busca
//     * @return retorna uma lista de pessoas que possuem este termo
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    protected ArrayList<Animal> pesquisarNome(String nome) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT * "
//                + "	FROM public.pessoa as p "
//                + "JOIN "
//                + "	(select c.id as ce_cidade_id, "
//                + "	 		c.nome as ce_cidade_nome, "
//                + "	 		e.id as ce_estado_id, "
//                + "	 		e.nome as ce_estado_nome, "
//                + "	 		e.sigla as ce_estado_sigla "
//                + "	 	from public.cidade as c "
//                + "	join public.estado as e "
//                + "	 	on e.id = c.estado_id "
//                + "	) ce "
//                + "	on p.cidade_id = ce.ce_cidade_id "
//                + "WHERE "
//                + "     registro_ativo = true and "
//                + "     p.nome like ?; ";
//
//        ArrayList<Animal> listaanimals = new ArrayList<>();
//        animal pessoa;
//        Cidade cidade;
//        Estado estado;
//
//        PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
//        statement.setString(1, "%" + nome + "%");
//        ResultSet resultado = statement.executeQuery();
//
//        while (resultado.next()) {
//            pessoa = new Animal();
//            cidade = new Cidade();
//            estado = new Estado();
//
//            pessoa.setAtivo(resultado.getBoolean("registro_ativo"));
//            pessoa.setBairro(resultado.getString("bairro"));
//            pessoa.setDataNascimento(new Date(resultado.getDate("data_nascimento").getTime()));
//            pessoa.setEndereco(resultado.getString("endereco"));
//            pessoa.setId(resultado.getInt("id"));
//            pessoa.setNome(resultado.getString("nome"));
//            pessoa.setNumero(resultado.getInt("numero"));
//            pessoa.setCidade(cidade);
//            cidade.setEstado(estado);
//
//            cidade.setId(resultado.getInt("ce_cidade_id"));
//            cidade.setNome(resultado.getString("ce_cidade_nome"));
//
//            estado.setId(resultado.getInt("ce_estado_id"));
//            estado.setNome(resultado.getString("ce_estado_nome"));
//            estado.setSigla(resultado.getString("ce_estado_sigla"));
//
//            listaanimals.add(pessoa);
//        }
//
//        return listaanimals;
//    }
//
//    /**
//     * Faz a pesquisa de uma pessoa com base em seu id
//     *
//     * @param id id utilizado na busca
//     * @return retornará a pessoa caso encontrado, senão, retornará null
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    protected Animal pesquisarId(int id) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT * "
//                + "	FROM public.pessoa as p "
//                + "JOIN "
//                + "	(select c.id as ce_cidade_id, "
//                + "	 		c.nome as ce_cidade_nome, "
//                + "	 		e.id as ce_estado_id, "
//                + "	 		e.nome as ce_estado_nome, "
//                + "	 		e.sigla as ce_estado_sigla "
//                + "	 	from public.cidade as c "
//                + "	join public.estado as e "
//                + "	 	on e.id = c.estado_id "
//                + "	) ce "
//                + "	on p.cidade_id = ce.ce_cidade_id "
//                + "WHERE "
//                + "     registro_ativo = true and "
//                + "     p.id = ?; ";
//
//        animal pessoa = null;
//        Cidade cidade;
//        Estado estado;
//
//        PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
//        statement.setInt(1, id);
//        ResultSet resultado = statement.executeQuery();
//
//        if (resultado.next()) {
//            pessoa = new animal();
//            cidade = new Cidade();
//            estado = new Estado();
//
//            pessoa.setAtivo(resultado.getBoolean("registro_ativo"));
//            pessoa.setBairro(resultado.getString("bairro"));
//            pessoa.setDataNascimento(new Date(resultado.getDate("data_nascimento").getTime()));
//            pessoa.setEndereco(resultado.getString("endereco"));
//            pessoa.setId(resultado.getInt("id"));
//            pessoa.setNome(resultado.getString("nome"));
//            pessoa.setNumero(resultado.getInt("numero"));
//            pessoa.setCidade(cidade);
//            cidade.setEstado(estado);
//
//            cidade.setId(resultado.getInt("ce_cidade_id"));
//            cidade.setNome(resultado.getString("ce_cidade_nome"));
//
//            estado.setId(resultado.getInt("ce_estado_id"));
//            estado.setNome(resultado.getString("ce_estado_nome"));
//            estado.setSigla(resultado.getString("ce_estado_sigla"));
//        }
//
//        return pessoa;
//    }
//
//    /**
//     * Método utilizado para reaproveitar código tanto do Excluir quanto do
//     * ReativarCadastro. Ele irá alterar a propriedade RegistroAtivo.
//     *
//     * @param bool variável utilizada para definir se o registro está ativo ou
//     * não
//     * @param id id utilizado na busca da pessoa
//     * @return retornará true caso a operação seja realizado com sucesso
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    private boolean excluirOuReativarCadastro(boolean bool, int id) throws ClassNotFoundException, SQLException {
//        String sql = "update animal set "
//                + "registro_ativo = ? "
//                + "where id = ? ";
//
//        PreparedStatement consulta = Conexao.getConexao().prepareStatement(sql);
//
//        consulta.setBoolean(1, bool);
//        consulta.setInt(2, id);
//
//        return consulta.executeUpdate() == 1;
//    }
//
//    /**
//     * Este método retorna o próximo ID da sequência de animal, garantindo
//     * unicidade. Vale ressaltar que um ID não pode ser compartilhado por mais
//     * de uma pessoa.
//     *
//     * @return retorna o próximo ID da sequência de pessoa no banco
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    private int nextVal() throws ClassNotFoundException, SQLException {
//        return Conexao.getConexao().prepareStatement("select nextval(pessoa_id_seq)").executeQuery().getInt("pessoa_id_seq");
//    }

}
