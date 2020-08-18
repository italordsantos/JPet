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
    
    ArrayList<Cidade> banco = Conexao.BD_CIDADE;
    
    public void cadastrarCidade(Cidade cidade) {
        if (getCidadeByName(cidade.getNome()).getNome() != null) {
            banco.add(cidade);
        }
    }
    
    public Cidade getCidadeByID(int id) {
        for (Cidade cidadeFor : banco) {
            if (cidadeFor.getId() == id) {
                return cidadeFor;
            }
        }
        return new Cidade();
    }
    
    public Cidade getCidadeByName(String nome) {
        for (Cidade cidadeFor : banco) {
            if (cidadeFor.getNome().equals(nome)) {
                return cidadeFor;
            }
        }
        return new Cidade();
    }
}
