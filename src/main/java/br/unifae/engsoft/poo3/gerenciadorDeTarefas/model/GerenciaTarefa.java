package br.unifae.engsoft.poo3.gerenciadorDeTarefas.model;

import java.util.ArrayList;
import java.util.List;



public class GerenciaTarefa{
   private static List<Tarefa> Tarefas = null;

    public static List getTarefas() {
        return Tarefas;
    }


   
    
    public GerenciaTarefa(){
        if(Tarefas == null){
            Tarefas = new ArrayList<Tarefa>();
        }
    }


   
   public static boolean cadastraTarefa(Tarefa tarefa){
       if(Tarefas == null){//Construtor do gerencia tarefas parou de funcionar. coloquei aqui e funcionou :)
            Tarefas = new ArrayList<Tarefa>();
        }
       
        if(tarefa != null){
            if(!(Tarefas.contains(tarefa)))
            return Tarefas.add(tarefa);
        }
            return false;    
   }
   

   
   public static boolean RemoverLista(Tarefa tarefa){
        if(tarefa != null){
            return Tarefas.remove(tarefa);
        }
        return false;
   }
   

   public static List<Tarefa> filtraTarefasPorPrioridade(int prioridade1) {
        List<Tarefa> tarefasFiltradas = new ArrayList<Tarefa>();
        if (Tarefas != null) {
            for (Tarefa tarefa : Tarefas) {
                if (tarefa.getPrioridade() >= prioridade1) {
                    tarefasFiltradas.add(tarefa);
                }
            }
        }
        return tarefasFiltradas;
    }
   
}
