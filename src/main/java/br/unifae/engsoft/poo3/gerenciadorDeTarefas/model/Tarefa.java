
package br.unifae.engsoft.poo3.gerenciadorDeTarefas.model;

import java.time.LocalDate;


public abstract class Tarefa {
    private String descricao;
    private boolean concluida;
    private int prioridade;
    private LocalDate dataCriacao;

    
    //construtores
    public Tarefa(){}
    
    public Tarefa(String descricao, int prioridade, LocalDate dataCriacao) {
       this.descricao = descricao;
       this.prioridade = prioridade;
       this.dataCriacao = dataCriacao;
       this.concluida = false;
    }
    
    @Override
    public String toString(){
        return "Descrição: [ " + getDescricao() + " ], concluida: [ " + isConcluida() + " ], "
            +  "Prioridade: [ " + getPrioridade() + " ], " + "Data: [ " + getDataCriacao() + " ],";
    }
    
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) { // Verifica se são o mesmo objeto
            return true;
        }

        
        if (obj == null || getClass() != obj.getClass()) { // Vai verifica se obj é nulo ou se as classes são diferentes
            return false;
        }

        Tarefa tarefa = (Tarefa) obj;

        if (!this.descricao.equals(tarefa.descricao)) {
            return false;
        }

        if (this.prioridade != tarefa.prioridade) {
            return false;
        }

        if (this.concluida != tarefa.concluida) {
            return false;
        }

    return this.dataCriacao.equals(tarefa.dataCriacao);
}

    
    //gets e sets
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    
}
