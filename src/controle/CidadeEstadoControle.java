/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cidade;
import modelo.dao.CidadeEstadoDAO;

/**
 *
 * @author italo
 */
public class CidadeEstadoControle extends CidadeEstadoDAO {

    @Override
    public ArrayList<String> listarSiglas() throws SQLException, Exception {
        return super.listarSiglas(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cidade> listarCidadesPorUF(String sigla) throws SQLException, Exception {
        return super.listarCidadesPorUF(sigla); //To change body of generated methods, choose Tools | Templates.
    }
    
}
