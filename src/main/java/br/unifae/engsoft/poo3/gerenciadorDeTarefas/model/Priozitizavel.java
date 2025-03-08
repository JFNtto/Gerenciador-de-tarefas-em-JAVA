
package br.unifae.engsoft.poo3.gerenciadorDeTarefas.model;

import java.util.List;


public interface Priozitizavel {
    //função que pergunta se quer priozirar uma tarefa especifica, se quiser joga
    //para uma tabela diferente logo no começo
    
    //mudar o nivel de prioridade
    public void priozirarTarefa(int novaPrioridade);
}
