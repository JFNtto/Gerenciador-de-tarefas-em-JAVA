
package br.unifae.engsoft.poo3.gerenciadorDeTarefas.controller;

import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.Tarefa;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class TelaInicialController {   

   
    public static void atualizaTabela(List<Tarefa> tarefasFiltradas, JTable tabela) {
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();


        for(Tarefa tarefa : tarefasFiltradas){
            dtm.addRow(new Object[]{tarefa.getDescricao(), tarefa.getPrioridade()});
        }
    }
}
