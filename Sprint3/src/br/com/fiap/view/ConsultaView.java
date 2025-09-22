package br.com.fiap.view;

import br.com.fiap.controller.ConsultaController;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultaView {
    public static void main(String[] args) {
        String nomeMed, observacao, local, aux, dia, mes, ano;
        LocalDateTime horario;
        String[] choice = {"Inserir", "Alterar", "Excluir", "Listar"};
        int option, idConsulta, idCliente;
        ConsultaController consultaCon = new ConsultaController();
        do {
            try {
                option = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Consulta:\n", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[0]);

                switch (option) {
                    case 0:
                        idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));
                        nomeMed = JOptionPane.showInputDialog(null, "Digite o nome do profissional da saúde", "Nome", JOptionPane.INFORMATION_MESSAGE);
                        local = JOptionPane.showInputDialog(null, "Digite o local", "Local", JOptionPane.INFORMATION_MESSAGE);
                        observacao = JOptionPane.showInputDialog(null, "Digite uma observação", "Observação", JOptionPane.INFORMATION_MESSAGE);

                        aux = JOptionPane.showInputDialog(null, "Digite a data do consulta (Dia/Mês/Ano)", "Data", JOptionPane.INFORMATION_MESSAGE);
                        dia = aux.substring(0,2);
                        mes = aux.substring(3,5);
                        ano = aux.substring(6,10);
                        horario = LocalDateTime.parse(ano+"-"+mes+"-"+dia);
                        System.out.println(consultaCon.inserirConsulta(idCliente, nomeMed, horario, local, observacao));
                        break;
                    case 1:
                        idConsulta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE));
                        nomeMed = JOptionPane.showInputDialog(null, "Digite o nome do profissional da saúde", "Nome", JOptionPane.INFORMATION_MESSAGE);
                        local = JOptionPane.showInputDialog(null, "Digite o local", "Local", JOptionPane.INFORMATION_MESSAGE);
                        observacao = JOptionPane.showInputDialog(null, "Digite uma observação", "Observação", JOptionPane.INFORMATION_MESSAGE);

                        aux = JOptionPane.showInputDialog(null, "Digite a data do consulta (Dia/Mês/Ano)", "Data", JOptionPane.INFORMATION_MESSAGE);
                        dia = aux.substring(0,2);
                        mes = aux.substring(3,5);
                        ano = aux.substring(6,10);
                        horario = LocalDateTime.parse(ano+"-"+mes+"-"+dia);
                        System.out.println(consultaCon.alterarConsulta(idConsulta, idCliente, nomeMed, horario, local, observacao));
                        break;
                    case 2:
                        idConsulta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID da consulta", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(consultaCon.excluirConsulta(idConsulta));
                        break;
                    case 3:
                        idConsulta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do consulta", "ID", JOptionPane.INFORMATION_MESSAGE));
                        System.out.println(consultaCon.listarUmaConsulta(idConsulta));
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
