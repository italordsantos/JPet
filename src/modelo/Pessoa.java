/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author italo
 */
public class Pessoa {

    private int id;
    private int numero;
    private boolean registroAtivo;
    private String nome;
    private String endereco;
    private String bairro;
    private LocalDate dataNascimento;
    private Cidade cidade;
    private ArrayList<Animal> listaAnimais;

    public Pessoa() {
    }

    public Pessoa(int id, int numero, boolean registroAtivo, String nome, String endereco, String bairro, LocalDate dataNascimento, Cidade cidade, ArrayList<Animal> listaAnimais) {
        this.id = id;
        this.numero = numero;
        this.registroAtivo = registroAtivo;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.listaAnimais = listaAnimais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isRegistroAtivo() {
        return registroAtivo;
    }

    public void setRegistroAtivo(boolean registroAtivo) {
        this.registroAtivo = registroAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Animal> getListaAnimais() {
        return listaAnimais;
    }

    public void setListaAnimais(ArrayList<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", numero=" + numero + ", registroAtivo=" + registroAtivo + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", dataNascimento=" + dataNascimento + ", cidade=" + cidade + ", listaAnimais=" + listaAnimais + '}';
    }

}
