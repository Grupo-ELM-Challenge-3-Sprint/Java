package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.dto.Consulta;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConsultaController {
    public String inserirConsulta(int idCliente, String nomeMed, LocalDateTime horario, String local, String observacao)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setIdCliente(idCliente);
        consulta.setNomeMed(nomeMed);
        consulta.setHorario(horario);
        consulta.setLocal(local);
        consulta.setObservacao(observacao);

        ConsultaDAO consultaDAO = new ConsultaDAO(con);
        resultado  = consultaDAO.inserir(consulta);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarConsulta(int idConsulta, int idCliente, String nomeMed, LocalDateTime horario, String local, String observacao)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);
        consulta.setIdCliente(idCliente);
        consulta.setNomeMed(nomeMed);
        consulta.setHorario(horario);
        consulta.setLocal(local);
        consulta.setObservacao(observacao);

        ConsultaDAO consultaDAO = new ConsultaDAO(con);
        resultado  = consultaDAO.alterar(consulta);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirConsulta(int idConsulta)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);

        ConsultaDAO consultaDAO = new ConsultaDAO(con);
        resultado  = consultaDAO.excluir(consulta);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmaConsulta(int idConsulta)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);

        ConsultaDAO consultaDAO = new ConsultaDAO(con);
        resultado  = consultaDAO.alterar(consulta);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
