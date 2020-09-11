/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pessoa;
import modelo.dao.PessoaDAO;

/**
 *
 * @author italo
 */
public class PessoaControle extends PessoaDAO {

    @Override
    public boolean inserir(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        return super.inserir(pessoa);
    }

    @Override
    public boolean alterar(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        return super.alterar(pessoa);
    }

    @Override
    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        return super.excluir(id);
    }

    @Override
    public boolean excluirDefinitivo(int id) throws ClassNotFoundException, SQLException {
        return super.excluirDefinitivo(id);
    }

    @Override
    public boolean reativarCadastro(int id) throws SQLException, ClassNotFoundException {
        return super.reativarCadastro(id);
    }

    @Override
    public ArrayList<Pessoa> listarPessoas() throws SQLException, ClassNotFoundException {
        return super.listarPessoas();
    }

    @Override
    public ArrayList<Pessoa> listarPessoas(boolean registro) throws SQLException, ClassNotFoundException {
        return super.listarPessoas(registro);
    }

    @Override
    public Pessoa pesquisarId(int id) throws SQLException, ClassNotFoundException {
        return super.pesquisarId(id);
    }

    @Override
    public ArrayList<Pessoa> pesquisarNome(String nome) throws SQLException, ClassNotFoundException {
        return super.pesquisarNome(nome);
    }

}
