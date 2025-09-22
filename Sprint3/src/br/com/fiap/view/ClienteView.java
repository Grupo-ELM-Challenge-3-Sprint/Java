package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;
import java.sql.SQLException;

public class ClienteView {
    public static void main(String[] args) {
        String cpf, nome, senha;
        String[] choice = {"Inserir", "Alterar", "Excluir", "Listar"};
        int option, idCliente;
        ClienteController clienteCon = new ClienteController();
        do {
            try {
                option = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Cliente:\n", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);

                switch (option) {
                    case 0:
                        cpf = JOptionPane.showInputDialog(null, "Digite o cpf", "CPF", JOptionPane.INFORMATION_MESSAGE);
                        nome = JOptionPane.showInputDialog(null, "Digite o nome", "Nome", JOptionPane.INFORMATION_MESSAGE);
                        senha = JOptionPane.showInputDialog(null, "Digite a senha", "Placa", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(clienteCon.inserirCliente(cpf, nome, senha));
                        break;
                    case 1:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID", "ID", JOptionPane.INFORMATION_MESSAGE));
                        cpf = JOptionPane.showInputDialog(null, "Digite o novo CPF", "Placa", JOptionPane.INFORMATION_MESSAGE);
                        nome = JOptionPane.showInputDialog(null, "Digite o novo nome", "Nome", JOptionPane.INFORMATION_MESSAGE);
                        senha = JOptionPane.showInputDialog(null, "Digite o nova senha", "Senha", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(clienteCon.alterarCliente(idCliente, cpf, nome, senha));
                        break;
                    case 2:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(clienteCon.excluirCliente(idCliente));
                        break;
                    case 3:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(clienteCon.listarUmCliente(idCliente));
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
