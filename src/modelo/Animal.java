/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author italo
 */
public class Animal {
    
    private int id;
    private String nome;
    private boolean registroAtivo;
    private Pessoa dono;

    public Animal() {
    }

    public Animal(int id, String nome, boolean registroAtivo) {
        this.id = id;
        this.nome = nome;
        this.registroAtivo = registroAtivo;
    }

    public Animal(int id, String nome, boolean registroAtivo, Pessoa dono) {
        this.id = id;
        this.nome = nome;
        this.registroAtivo = registroAtivo;
        this.dono = dono;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isRegistroAtivo() {
        return registroAtivo;
    }

    public void setRegistroAtivo(boolean registroAtivo) {
        this.registroAtivo = registroAtivo;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", registroAtivo=" + registroAtivo + ", dono=" + dono + '}';
    }
    
}
