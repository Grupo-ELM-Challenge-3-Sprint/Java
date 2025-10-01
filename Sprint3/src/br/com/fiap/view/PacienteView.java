package br.com.fiap.view;

import br.com.fiap.controller.PacienteController;

import javax.swing.*;

/**
 * Classe <strong>PacienteView</strong>, onde são chamados os metodos CRUD para manipular objetos da classe <strong>Paciente</strong> por meio dos <strong>Controllers</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class PacienteView {
    public static void main(String[] args) {
        String nome, senha, cpf;
        String[] choice = {"Inserir", "Alterar", "Excluir", "Listar"};
        int option, idPaciente;
        PacienteController pacienteCon = new PacienteController();
        do {
            try {
                option = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Paciente:\n", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);

                switch (option) {
                    case 0:
                        cpf = JOptionPane.showInputDialog(null, "Digite o cpf", "CPF", JOptionPane.INFORMATION_MESSAGE);
                        nome = JOptionPane.showInputDialog(null, "Digite o nome", "Nome", JOptionPane.INFORMATION_MESSAGE);
                        senha = JOptionPane.showInputDialog(null, "Digite a senha", "CPF", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(pacienteCon.inserirPaciente(cpf, nome, senha));
                        break;
                    case 1:
                        idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID", "ID", JOptionPane.INFORMATION_MESSAGE));
                        cpf = JOptionPane.showInputDialog(null, "Digite o novo CPF", "CPF", JOptionPane.INFORMATION_MESSAGE);
                        nome = JOptionPane.showInputDialog(null, "Digite o novo nome", "Nome", JOptionPane.INFORMATION_MESSAGE);
                        senha = JOptionPane.showInputDialog(null, "Digite o nova senha", "Senha", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(pacienteCon.alterarPaciente(idPaciente, cpf, nome, senha));
                        break;
                    case 2:
                        idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do paciente", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(pacienteCon.excluirPaciente(idPaciente));
                        break;
                    case 3:
                        idPaciente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do paciente", "ID", JOptionPane.INFORMATION_MESSAGE));
                        JOptionPane.showMessageDialog(null, pacienteCon.listarUmPaciente(idPaciente));
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
