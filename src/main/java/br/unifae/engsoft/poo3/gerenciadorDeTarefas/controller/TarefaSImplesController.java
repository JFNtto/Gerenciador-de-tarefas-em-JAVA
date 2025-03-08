
package br.unifae.engsoft.poo3.gerenciadorDeTarefas.controller;

import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.GerenciaTarefa;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.Priozitizavel;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.Tarefa;
import br.unifae.engsoft.poo3.gerenciadorDeTarefas.model.TarefaSimples;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TarefaSImplesController implements Priozitizavel{

    /**
     * 
     * @param descricao descricao da tarefa
     * @param prioridade 1 a 5 
     * @param data data criacao da tarefa
     * @return true se pode cadastrar e false caso contrario
     */
    public boolean cadastrar(String descricao, int prioridade, LocalDate data){
       return GerenciaTarefa.cadastraTarefa(new TarefaSimples(descricao, prioridade, data));        
    }
    
        public static void atualizaTabela(JTable tabela, List<Tarefa> Tarefas){
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();


        for(Tarefa tarefa : Tarefas){
            if(tarefa instanceof TarefaSimples tarefaSimples){
                dtm.addRow(new Object[]{tarefaSimples.getDescricao(), tarefaSimples.getPrioridade(), tarefaSimples.getDataCriacao()});
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
                
                if(tarefaParaRemover != null){
                    boolean removida = GerenciaTarefa.RemoverLista(tarefaParaRemover);
                    if(removida){                   
                        dtm.removeRow(linha);
                        JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro ao remover a tarefa!.", "Aviso!", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Tarefa não encontrada na lista.", "Aviso!", JOptionPane.ERROR_MESSAGE);
                }
              }
            }
        }
        
        public void editarItemSimples(String descricaoNova, int prioridadeNova, boolean concluidaNova){
           List<Tarefa> tarefas = GerenciaTarefa.getTarefas();

            for(Tarefa tarefa : tarefas){
            if(tarefa instanceof TarefaSimples tarefaSimples){
                if(concluidaNova){                  
                    GerenciaTarefa.RemoverLista(tarefaSimples);
                    JOptionPane.showMessageDialog(null, "Eba a tarefa foi concluida", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                   
                    tarefaSimples.setDescricao(descricaoNova);
                    tarefaSimples.setPrioridade(prioridadeNova);
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


