package br.com.fiap.view;

import br.com.fiap.controller.ReceitaController;
import br.com.fiap.controller.ReceitaController;

import javax.swing.*;
import java.time.LocalDateTime;

public class ReceitaView {
    public static void main(String[] args) {
        String medicamento, prescricao;
        String[] choice = {"Inserir", "Alterar", "Excluir", "Listar"};
        int option, idReceita, idCliente;
        ReceitaController receitaCon = new ReceitaController();
        do {
            try {
                option = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Receita:\n", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);

                switch (option) {
                    case 0:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));
                        medicamento = JOptionPane.showInputDialog(null, "Digite o nome do medicamento", "Medicamento", JOptionPane.INFORMATION_MESSAGE);
                        prescricao = JOptionPane.showInputDialog(null, "Digite a prescrição (horário para tomar o remédio e quantas vezes", "Prescrição", JOptionPane.INFORMATION_MESSAGE);
                        
                        System.out.println(receitaCon.inserirReceita(idCliente, medicamento, prescricao));
                        break;
                    case 1:
                        idReceita = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));
                        medicamento = JOptionPane.showInputDialog(null, "Digite o nome do medicamento", "Medicamento", JOptionPane.INFORMATION_MESSAGE);
                        prescricao = JOptionPane.showInputDialog(null, "Digite a prescrição (horário para tomar o remédio e quantas vezes", "Prescrição", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(receitaCon.alterarReceita(idReceita, idCliente, medicamento, prescricao));
                        break;
                    case 2:
                        idReceita = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da receita", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(receitaCon.excluirReceita(idReceita));
                        break;
                    case 3:
                        idReceita = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do receita", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(receitaCon.listarUmaReceita(idReceita));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim do programa", "Fim", JOptionPane.INFORMATION_MESSAGE);
    }
}
