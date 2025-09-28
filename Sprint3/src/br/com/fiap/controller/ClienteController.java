package br.com.fiap.controller;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe para criar objetos do tipo <strong>ClienteController</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ClienteController {
    /**
     * O metodo <strong>inserirCliente</strong>, recebe os atributos do cliente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ClienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe cliente e passa ele por parametro para o metodo inserir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ClienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param cpf é o cpf do cliente passado por parametro.
     * @param nome é o nome do cliente passado por parametro.
     * @param senha é a senha do cliente passada por parametro.
     */
    public String inserirCliente(String cpf, String nome, String senha) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setSenha(senha);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    /**
     * O metodo <strong>alterarCliente</strong>, recebe os atributos do cliente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ClienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe cliente e passa ele por parametro para o metodo alterar. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ClienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idCliente é o id do cliente passado por parametro.
     * @param cpf é o cpf do cliente passado por parametro.
     * @param nome é o nome do cliente passado por parametro.
     * @param senha é a senha do cliente passada por parametro.
     */
    public String alterarCliente(int idCliente, String cpf, String nome, String senha) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setSenha(senha);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.alterar(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    /**
     * O metodo <strong>excluirCliente</strong>, recebe os atributos do cliente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ClienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe cliente e passa ele por parametro para o metodo excluir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ClienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idCliente é o id do cliente passado por parametro.
     */
    public String excluirCliente(int idCliente) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.excluir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    /**
     * O metodo <strong>listarUmCliente</strong>, recebe os atributos do cliente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ClienteDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe cliente e passa ele por parametro para o metodo listarUm. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ClienteView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idCliente é o id do cliente passado por parametro.
     */
    public String listarUmCliente(int idCliente) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.listarUm(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
