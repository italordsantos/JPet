/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.Cidade;

/**
 *
 * @author italo
 */
public class CidadeDAO {
    
    ArrayList<Cidade> BD = Conexao.BD_CIDADE;
    
    public Cidade getCidadeByID(int id) {
        Cidade cidade = new Cidade();
        return cidade;
    }
    
    public Cidade getCidadeByName(String nome) {
        Cidade cidade = new Cidade();
        return cidade;
    }
}
