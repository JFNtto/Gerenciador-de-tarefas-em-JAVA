
package br.unifae.engsoft.poo3.gerenciadorDeTarefas.model;

import java.time.LocalDate;


public class TarefaComPrazo extends Tarefa{
    private LocalDate prazo;

    
    //construtor
    public TarefaComPrazo(){}

    public TarefaComPrazo(LocalDate prazo, String descricao, int prioridade, LocalDate dataCriacao) {
        super(descricao, prioridade, dataCriacao);
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return super.toString() + "Prazos [ " + prazo + " ]";
    }
    
    
    public boolean equals(Object obj){
        if(super.equals(obj)){
            if(this.prazo.equals(((TarefaComPrazo)obj).prazo))
                return true;
                    
        }
        return false;
    }

    
    
    
    //gets e sets
    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
    
    
}
