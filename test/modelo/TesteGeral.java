/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
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
        
        Animal animal0 = new Animal(0, "BILI", true);
        Animal animal1 = new Animal(1, "TOTO", true);
        Animal animal2 = new Animal(2, "PELUCIA", true);
        Animal animal3 = new Animal(3, "SALSICHA", true);
        
        ArrayList<Animal> listaAnimal1 = new ArrayList<>();
        ArrayList<Animal> listaAnimal2 = new ArrayList<>();
        listaAnimal1.add(animal3);
        
        
        Pessoa pessoa1 = new Pessoa(
                "ITALO",
                0,
                574,
                true,
                "AVENIDA BELO HORIZONTE",
                "CENTRO",
                LocalDate.of(12, 04, 2000),
                cidade1,
                listaAnimal1
                );
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
