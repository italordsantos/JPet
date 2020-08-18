/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class Venda {
    
    private int id;
    private boolean registroAtivo;
    private LocalDateTime dataHora;
    private Pessoa cliente;
    private final ArrayList<ProdutosServicos> listaProdutosServicos = new ArrayList<>();
    private Animal animal;

    public Venda() {
    }

    public Venda(int id, boolean registroAtivo, LocalDateTime dataHora, Pessoa cliente, Animal animal) {
        this.id = id;
        this.registroAtivo = registroAtivo;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRegistroAtivo() {
        return registroAtivo;
    }

    public void setRegistroAtivo(boolean registroAtivo) {
        this.registroAtivo = registroAtivo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", registroAtivo=" + registroAtivo + ", dataHora=" + dataHora + ", cliente=" + cliente + ", listaProdutosServicos=" + listaProdutosServicos + ", animal=" + animal + '}';
    }
    
}
