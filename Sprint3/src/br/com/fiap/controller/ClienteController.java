package br.com.fiap.controller;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class ClienteController {
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
    public String excluirCliente(int idCliente) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);

        ClienteDAO clienteDAO = new ClienteDAO(con);
        resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
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
