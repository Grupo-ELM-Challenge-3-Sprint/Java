package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.ReceitaDAO;
import br.com.fiap.model.dto.Receita;

import java.sql.Connection;
import java.sql.SQLException;

public class ReceitaController {
    public String inserirReceita(int idCliente, String medicamento, String prescricao)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdCliente(idCliente);
        receita.setMedicamento(medicamento);
        receita.setPrescricao(prescricao);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.inserir(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarReceita(int idReceita, int idCliente, String medicamento, String prescricao)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdReceita(idReceita);
        receita.setIdCliente(idCliente);
        receita.setMedicamento(medicamento);
        receita.setPrescricao(prescricao);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.alterar(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirReceita(int idReceita)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdReceita(idReceita);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.excluir(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmaReceita(int idReceita)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdReceita(idReceita);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.alterar(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
