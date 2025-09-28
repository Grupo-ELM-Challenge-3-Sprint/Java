package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.dto.Consulta;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Classe para criar objetos do tipo <strong>ConsultaController</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ConsultaController {
    /**
     * O metodo <strong>inserirConsulta</strong>, recebe os atributos do consulta por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ConsultaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe consulta e passa ele por parametro para o metodo inserir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ConsultaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idCliente é o id do cliente passado por parametro.
     * @param nomeMed é o nome do profissional da saúde que participa da consulta passado por parametro.
     * @param horario é o horário da consulta passado por parametro.
     * @param local é o local da consulta passado por parametro.
     * @param observacao é a observação da consulta passada por parametro.
     */
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

    /**
     * O metodo <strong>alterarConsulta</strong>, recebe os atributos do consulta por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ConsultaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe consulta e passa ele por parametro para o metodo alterar. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ConsultaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idConsulta é o id do consulta passado por parametro.
     * @param idCliente é o id do cliente passado por parametro.
     * @param nomeMed é o nome do profissional da saúde que participa da consulta passado por parametro.
     * @param horario é o horário da consulta passado por parametro.
     * @param local é o local da consulta passado por parametro.
     * @param observacao é a observação da consulta passada por parametro.
     */
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

    /**
     * O metodo <strong>excluirConsulta</strong>, recebe os atributos do consulta por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ConsultaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe consulta e passa ele por parametro para o metodo excluir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ConsultaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idConsulta é o id do consulta passado por parametro.
     */
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

    /**
     * O metodo <strong>listarUmaConsulta</strong>, recebe os atributos do consulta por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ConsultaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe consulta e passa ele por parametro para o metodo listarUm. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ConsultaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idConsulta é o id do consulta passado por parametro.
     */
    public String listarUmaConsulta(int idConsulta)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);

        ConsultaDAO consultaDAO = new ConsultaDAO(con);
        resultado  = consultaDAO.listarUm(consulta);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
