/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cidade;
import modelo.Estado;

/**
 *
 * @author Rafael
 */
public class CidadeEstadoDAO {

    /**
     * Lista todas as cidades pertencentes a um determinado estado
     *
     * @param sigla sigla do estado a ser buscado
     * @return retorna todas cidades do estado passado via Sigla
     * @throws SQLException
     * @throws Exception
     */
    protected ArrayList<Cidade> listarCidadesPorUF(String sigla) throws SQLException, Exception {
        ArrayList<Cidade> listaCidades = new ArrayList<>();
        Cidade cidade;
        Estado estado;

        String sql = "select c.id, "
                + "	   c.nome, "
                + "	   e.id as idestado, "
                + "	   e.nome as nomeestado, "
                + "	   sigla "
                + "from cidade c "
                + "join estado e on c.estado_id = e.id "
                + "where e.sigla like ? "
                + "order by c.nome asc;";

        PreparedStatement statemant = Conexao.getConexao().prepareStatement(sql);
        statemant.setString(1, sigla);

        ResultSet resultado = statemant.executeQuery();

        while (resultado.next()) {
            cidade = new Cidade();
            estado = new Estado();

            estado.setId(resultado.getInt("idestado"));
            estado.setNome(resultado.getString("nomeestado"));
            estado.setSigla(resultado.getString("sigla"));

            cidade.setId(resultado.getInt("id"));
            cidade.setNome(resultado.getString("nome"));
            cidade.setEstado(estado);

            listaCidades.add(cidade);
        }

        return listaCidades;
    }

    /**
     * Lista todas as siglas dos estados brasileiros e o Distrito Federal
     *
     * @return retorna todas as siglas dos estados brasileiros bem como do
     * Distrito Federal
     * @throws SQLException
     * @throws Exception
     */
    protected ArrayList<String> listarSiglas() throws SQLException, Exception {
        ArrayList<String> listaUf = new ArrayList<>();
        String sql = "select sigla from estado order by nome asc;";

        PreparedStatement statemant = Conexao.getConexao().prepareStatement(sql);

        ResultSet resultado = statemant.executeQuery();

        while (resultado.next()) {
            listaUf.add(resultado.getString("sigla"));
        }

        return listaUf;
    }

}
