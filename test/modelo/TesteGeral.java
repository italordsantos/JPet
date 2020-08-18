/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.dao.CidadeDAO;
import modelo.dao.EstadoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author italo
 */
public class TesteGeral {
    
    EstadoDAO daoEstadoDAO;
    CidadeDAO daoCidadeDAO;
    
    public TesteGeral() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        daoEstadoDAO = new EstadoDAO();
        daoCidadeDAO = new CidadeDAO();
        
        Estado estado1 = new Estado(0, "PARANÁ", "PR");
        Estado estado2 = new Estado(1, "SÃO PAULO", "SP");

        daoEstadoDAO.cadastrarEstado(estado1);
        daoEstadoDAO.cadastrarEstado(estado2);
        
        Cidade cidade1 = new Cidade(0, "FORMOSA DO OESTE", estado1);
        Cidade cidade2 = new Cidade(1, "ASSIS CHATEAUBRIAND", estado1);
        Cidade cidade3 = new Cidade(2, "JESUÍTAS", estado1);
        Cidade cidade4 = new Cidade(3, "SÃO PAULO", estado2);
        
        daoCidadeDAO.cadastrarCidade(cidade1);
        daoCidadeDAO.cadastrarCidade(cidade2);
        daoCidadeDAO.cadastrarCidade(cidade3);
        daoCidadeDAO.cadastrarCidade(cidade4);
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
