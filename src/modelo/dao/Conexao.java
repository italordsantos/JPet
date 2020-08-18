/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import modelo.Animal;
import modelo.Cidade;
import modelo.Estado;
import modelo.Pessoa;
import modelo.ProdutosServicos;
import modelo.Venda;

/**
 *
 * @author italo
 */
public class Conexao {
    
    public static final ArrayList<Animal> BD_ANIMAL = new ArrayList<>();
    public static final ArrayList<Cidade> BD_CIDADE = new ArrayList<>();
    public static final ArrayList<Estado> BD_ESTADO = new ArrayList<>();
    public static final ArrayList<Pessoa> BD_PESSOA = new ArrayList<>();
    public static final ArrayList<ProdutosServicos> BD_PRODUTO_SERVICO = new ArrayList<>();
    public static final ArrayList<Venda> BD_VENDA = new ArrayList<>();
}
