package br.com.fiap.controller;

import br.com.fiap.model.dao.PacienteDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Paciente;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe para criar objetos do tipo <strong>PacienteController</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class PacienteController {
    /**
     * O metodo <strong>inserirPaciente</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>PacienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe paciente e passa ele por parametro para o metodo inserir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>PacienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param cpf é o cpf do paciente passado por parametro.
     * @param nome é o nome do paciente passado por parametro.
     * @param senha é a senha do paciente passada por parametro.
     */
    public String inserirPaciente(String cpf, String nome, String senha) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setCpf(cpf);
        paciente.setNome(nome);
        paciente.setSenha(senha);

        PacienteDAO pacienteDAO = new PacienteDAO(con);
        resultado = pacienteDAO.inserir(paciente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    /**
     * O metodo <strong>alterarPaciente</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>PacienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe paciente e passa ele por parametro para o metodo alterar. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>PacienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idPaciente é o id do paciente passado por parametro.
     * @param cpf é o cpf do paciente passado por parametro.
     * @param nome é o nome do paciente passado por parametro.
     * @param senha é a senha do paciente passada por parametro.
     */
    public String alterarPaciente(int idPaciente, String cpf, String nome, String senha) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);
        paciente.setCpf(cpf);
        paciente.setNome(nome);
        paciente.setSenha(senha);

        PacienteDAO pacienteDAO = new PacienteDAO(con);
        resultado = pacienteDAO.alterar(paciente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    /**
     * O metodo <strong>excluirPaciente</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>PacienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe paciente e passa ele por parametro para o metodo excluir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>PacienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idPaciente é o id do paciente passado por parametro.
     */
    public String excluirPaciente(int idPaciente) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);

        PacienteDAO pacienteDAO = new PacienteDAO(con);
        resultado = pacienteDAO.excluir(paciente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    /**
     * O metodo <strong>listarUmPaciente</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>PacienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe paciente e passa ele por parametro para o metodo listarUm. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>PacienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idPaciente é o id do paciente passado por parametro.
     */
    public String listarUmPaciente(int idPaciente) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);

        PacienteDAO pacienteDAO = new PacienteDAO(con);
        resultado = pacienteDAO.listarUm(paciente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
