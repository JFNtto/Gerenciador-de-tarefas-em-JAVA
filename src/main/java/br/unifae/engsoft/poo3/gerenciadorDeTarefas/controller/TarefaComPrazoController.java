
package br.unifae.engsoft.poo3.gerenciadorDeTarefas.controller;

import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.GerenciaTarefa;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.Priozitizavel;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.Tarefa;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.TarefaComPrazo;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.TarefaSimples;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TarefaComPrazoController implements Priozitizavel{
    public boolean cadastrar(LocalDate prazo, String descricao, int prioridade, LocalDate data){
        return GerenciaTarefa.cadastraTarefa(new TarefaComPrazo(prazo, descricao, prioridade, data));
    }
    
    
    public static void atualizaTabela(JTable tabela, List<Tarefa> Tarefas){
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();


        for(Tarefa tarefa : Tarefas){
            if(tarefa instanceof TarefaComPrazo tarefaComPrazo){
                dtm.addRow(new Object[]{tarefaComPrazo.getDescricao(), tarefaComPrazo.getPrioridade(), tarefaComPrazo.getDataCriacao(), tarefaComPrazo.getPrazo()});
            }
        }
    
    }
    
    
    public void excluirItem(JTable tabela){
            if(tabela.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Selecione um item da tabela", "Aviso!", 0);
            }else{
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer apagar essa tarefa?", "Aviso!", JOptionPane.YES_NO_OPTION);
                
                if(resposta == JOptionPane.YES_OPTION){
                    DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
                    int linha = tabela.getSelectedRow();
                    String descricao = (String) dtm.getValueAt(linha, 0);//só pra fazer o equal e apgar da tabela e da list
                    //remover a linha selecionada da tabela que foi passada
                    
                    List<Tarefa> tarefas = GerenciaTarefa.getTarefas();
                    Tarefa tarefaParaRemover = null;

                for(Tarefa tarefa : tarefas){
                    if(tarefa.getDescricao().equals(descricao)){
                        tarefaParaRemover = tarefa;
                        break;
                        }
                   }
                //verifica se pode dar algum erro
                if(tarefaParaRemover != null){
                boolean removida = GerenciaTarefa.RemoverLista(tarefaParaRemover);
                if(removida){                    
                    dtm.removeRow(linha);
                    JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao remover a tarefa da lista.", "Aviso!", JOptionPane.ERROR_MESSAGE);
                }   
                }else{
                JOptionPane.showMessageDialog(null, "Tarefa não encontrada na lista.", "Aviso!", JOptionPane.ERROR_MESSAGE);
                }
              }
            }
        }
    
    
    
    
    public void editarItemPrazo(String descricaoNova, int prioridadeNova, boolean concluidaNova, LocalDate prazoNova){
           List<Tarefa> tarefas = GerenciaTarefa.getTarefas();

            for(Tarefa tarefa : tarefas){
            if(tarefa instanceof TarefaComPrazo tarefaComPrazo){
                if(concluidaNova){                  
                    GerenciaTarefa.RemoverLista(tarefaComPrazo);
                    JOptionPane.showMessageDialog(null, "Eba a tarefa foi concluida", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{                   
                    tarefaComPrazo.setDescricao(descricaoNova);
                    tarefaComPrazo.setPrioridade(prioridadeNova);
                    tarefaComPrazo.setPrazo(prazoNova);
                    JOptionPane.showMessageDialog(null, "Tarefa atualizada", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                    break;
                }
            }    
       }
    
    
     @Override
       public void priozirarTarefa(int prioridadeNova){
            List<Tarefa> tarefas = GerenciaTarefa.getTarefas();

            for(Tarefa tarefa : tarefas){
            if(tarefa instanceof TarefaSimples tarefaSimples){

                    tarefaSimples.setPrioridade(prioridadeNova);
                    JOptionPane.showMessageDialog(null, "A Prioridade da tarefa aumentou", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                    break;
                }
            }
    
}
