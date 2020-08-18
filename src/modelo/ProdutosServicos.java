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
public class ProdutosServicos {
    
    private int id;
    private int frequenciaAplicacaoDias;
    private float valor;
    private boolean servico;
    private boolean registroAtivo;
    private String nome;

    public ProdutosServicos() {
    }

    public ProdutosServicos(int id, int frequenciaAplicacaoDias, float valor, boolean servico, boolean registroAtivo, String nome) {
        this.id = id;
        this.frequenciaAplicacaoDias = frequenciaAplicacaoDias;
        this.valor = valor;
        this.servico = servico;
        this.registroAtivo = registroAtivo;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrequenciaAplicacaoDias() {
        return frequenciaAplicacaoDias;
    }

    public void setFrequenciaAplicacaoDias(int frequenciaAplicacaoDias) {
        this.frequenciaAplicacaoDias = frequenciaAplicacaoDias;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isServico() {
        return servico;
    }

    public void setServico(boolean servico) {
        this.servico = servico;
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

    @Override
    public String toString() {
        return "ProdutosServicos{" + "id=" + id + ", frequenciaAplicacaoDias=" + frequenciaAplicacaoDias + ", valor=" + valor + ", servico=" + servico + ", registroAtivo=" + registroAtivo + ", nome=" + nome + '}';
    }
    
}
