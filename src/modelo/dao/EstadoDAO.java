/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.Estado;

/**
 *
 * @author italo
 */
public class EstadoDAO {
    
    ArrayList<Estado> banco = Conexao.BD_ESTADO;
    
    public void cadastrarEstado(Estado estado) {
        if (estado.getId() == 0) {
            banco.add(estado);
        }
    }
    
    public Estado getEstadoByID(int id) {
        for (Estado estadoFor : banco) {
            if (estadoFor.getId() == id) {
                return estadoFor;
            }
        }
        
        return new Estado();
    }
    
    public Estado getEstadoBySigla(String sigla) {
        for (Estado estadoFor : banco) {
            if (estadoFor.getSigla().equals(sigla)) {
                return estadoFor;
            }
        }        
        return new Estado();
    }
    
    public Estado getEstadoByName(String nome) {
        for (Estado estadoFor : banco) {
            if (estadoFor.getNome().equals(nome)) {
                return estadoFor;
            }
        }
        return new Estado();
    }
}
