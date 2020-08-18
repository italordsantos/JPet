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
    
    public Estado getEstadoByID(int id) {
        Estado estado = new Estado();
        return estado;
    }
    
    public Estado getEstadoBySigla(String sigla) {
        Estado estado = new Estado();
        return estado;
    }
    
    public Estado getEstadoByName(String nome) {
        Estado estado = new Estado();
        return estado;
    }
}
