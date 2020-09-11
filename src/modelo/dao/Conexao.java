/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class Conexao {

    private static Connection conexao;

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        if (conexao == null){
           Class.forName("org.postgresql.Driver"); 
           conexao = DriverManager.getConnection(
                   "jdbc:postgresql://localhost:5432/petshop", //URL
                   "postgres", //LOGIN
                   "abc123*"); //SENHA
        }
        return conexao;
    }
    
    public static PreparedStatement preparedStatement(String sql) throws ClassNotFoundException, SQLException {
        return getConexao().prepareStatement(sql);
    }

}
