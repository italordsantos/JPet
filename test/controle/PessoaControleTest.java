/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Cidade;
import modelo.Pessoa;
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
public class PessoaControleTest {

    public PessoaControleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
    }

    /**
     * Test of inserir method, of class PessoaControle.
     *
     * @throws java.lang.Exception
     */
//    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        Pessoa pessoa = new Pessoa();
        Cidade cidade = new Cidade();

        pessoa.setAtivo(true);
        pessoa.setBairro("Novo bairro");
        pessoa.setCidade(cidade);
        pessoa.setDataNascimento(new Date());
        pessoa.setEndereco("av belo horizonte");
        pessoa.setNome("italo");
        pessoa.setNumero(15);
        cidade.setId(20);

        PessoaControle instance = new PessoaControle();
        boolean expResult = true;
        boolean result = instance.inserir(pessoa);
        assertEquals(expResult, result);
    }

    /**
     * Test of pesquisarNome method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testPesquisarNome() throws Exception {
        System.out.println("pesquisarNome");

        String nome = "a";
        
        PessoaControle instance = new PessoaControle();
        ArrayList<Pessoa> listaPessoas = instance.pesquisarNome(nome);
        boolean expResult = true;
        boolean result = listaPessoas.size() > 0;

        assertEquals(expResult, result);
        
        listaPessoas.forEach((pessoa) -> {
            System.out.println(pessoa);
        });
    }

    /**
     * Test of excluir method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        int id = 3;
        
        PessoaControle instance = new PessoaControle();
        Pessoa pessoa = instance.pesquisarId(id);
        pessoa.setAtivo(false);
        
        instance.excluir(id);
        
        boolean expResult = true;
        boolean result = instance.pesquisarId(id) == null;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of alterar method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        String nome = "Karol";
        int id = 1;
        
        PessoaControle instance = new PessoaControle();
        Pessoa pessoa = instance.pesquisarId(id);
        pessoa.setNome(nome);
        
        boolean expResult = true;
        boolean result = instance.alterar(pessoa);
        
        assertEquals(expResult, result);
        
        System.out.println(instance.pesquisarId(id));
    }

    /**
     * Test of listarPessoas method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testListarPessoas_0args() throws Exception {
        System.out.println("listarPessoas");
        
        PessoaControle instance = new PessoaControle();
        ArrayList<Pessoa> listaPessoas = instance.listarPessoas();
        boolean expResult = true;
        int result = listaPessoas.size();
        
        assertEquals(expResult, result > 0);

        listaPessoas.forEach((pessoa) -> {
            System.out.println(pessoa);
        });
    }

    /**
     * Test of pesquisarId method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testPesquisarId() throws Exception {
        System.out.println("pesquisarId");
        
        int id = 3;
        PessoaControle instance = new PessoaControle();
        Pessoa pessoa = instance.pesquisarId(id);
        
        int expResult = id;
        int result = pessoa.getId();
        
        assertEquals(expResult, result);
        
        System.out.println(pessoa);
    }

    /**
     * Test of reativarCadastro method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testReativarCadastro() throws Exception {
        System.out.println("reativarCadastro");
        
        int id = 3;
        PessoaControle instance = new PessoaControle();
        
        
        boolean expResult = true;
        boolean result = instance.reativarCadastro(id);
        
        assertEquals(expResult, result);
        
        System.out.println(instance.pesquisarId(id));
    }

    /**
     * Test of excluirDefinitivo method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testExcluirDefinitivo() throws Exception {
        System.out.println("excluirDefinitivo");
        
        int id = 44;
        PessoaControle instance = new PessoaControle();
        
        boolean expResult = false;
        boolean result = instance.excluirDefinitivo(id);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of listarPessoas method, of class PessoaControle.
     * @throws java.lang.Exception
     */
//    @Test
    public void testListarPessoas_boolean() throws Exception {
        System.out.println("listarPessoas");
        
        boolean registro_ativo = true;
        PessoaControle instance = new PessoaControle();
        ArrayList<Pessoa> listaPessoas = instance.listarPessoas(registro_ativo);
        boolean expResult = true;
        int result = listaPessoas.size();
        
        assertEquals(expResult, result > 0);

        listaPessoas.forEach((pessoa) -> {
            System.out.println(pessoa);
        });
    }

}
