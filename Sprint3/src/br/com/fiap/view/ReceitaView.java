package br.com.fiap.view;

import br.com.fiap.controller.ReceitaController;

import javax.swing.*;

/**
 * Classe <strong>ReceitaView</strong>, onde são chamados os metodos CRUD para manipular objetos da classe <strong>Receita</strong> por meio dos <strong>Controllers</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ReceitaView {
    public static void main(String[] args) {
        String medicamento, prescricao;
        String[] choice = {"Inserir", "Alterar", "Excluir", "Listar"};
        int option, idReceita, idPaciente;
        ReceitaController receitaCon = new ReceitaController();
        do {
            try {
                option = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Receita:\n", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);

                switch (option) {
                    case 0:
                        idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do paciente", "Paciente", JOptionPane.INFORMATION_MESSAGE));
                        medicamento = JOptionPane.showInputDialog(null, "Digite o nome do medicamento", "Medicamento", JOptionPane.INFORMATION_MESSAGE);
                        prescricao = JOptionPane.showInputDialog(null, "Digite a prescrição (horário para tomar o remédio e quantas vezes", "Prescrição", JOptionPane.INFORMATION_MESSAGE);
                        
                        System.out.println(receitaCon.inserirReceita(idPaciente, medicamento, prescricao));
                        break;
                    case 1:
                        idReceita = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da receita", "Receita", JOptionPane.INFORMATION_MESSAGE));
                        idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do paciente", "Paciente", JOptionPane.INFORMATION_MESSAGE));
                        medicamento = JOptionPane.showInputDialog(null, "Digite o nome do medicamento", "Medicamento", JOptionPane.INFORMATION_MESSAGE);
                        prescricao = JOptionPane.showInputDialog(null, "Digite a prescrição (horário para tomar o remédio e quantas vezes", "Prescrição", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(receitaCon.alterarReceita(idReceita, idPaciente, medicamento, prescricao));
                        break;
                    case 2:
                        idReceita = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da receita", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(receitaCon.excluirReceita(idReceita));
                        break;
                    case 3:
                        idReceita = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do receita", "ID", JOptionPane.INFORMATION_MESSAGE));
                        JOptionPane.showMessageDialog(null, receitaCon.listarUmaReceita(idReceita));
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
