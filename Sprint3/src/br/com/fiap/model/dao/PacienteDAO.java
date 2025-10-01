package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe para criar objetos do tipo <strong>PacienteDAO</strong> que implementa a interface <strong>IDAO</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class PacienteDAO implements IDAO {
    private Connection con;
    private Paciente paciente;

    public PacienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    /**
     * O metodo <strong>inserir</strong>, recebe um objeto por parametro, que vai ser o paciente, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos cpf, nome, senha do object e coloca eles no preparedStatement, que usa a conexão para <strong>inserir</strong> o paciente na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String inserir(Object object) {
        paciente = (Paciente) object;
        String sql = "INSERT INTO ddd_paciente(cpf, nm_paci, senha) VALUES(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getSenha());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    /**
     * O metodo <strong>alterar</strong>, recebe um objeto por parametro, que vai ser o paciente, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idPaciente, cpf, nome, senha do object e coloca eles no preparedStatement, que usa a conexão para <strong>alterar</strong> o paciente na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String alterar(Object object) {
        paciente = (Paciente) object;
        String sql = "UPDATE ddd_paciente SET cpf = ?, nm_paci = ?, senha = ? WHERE id_paci = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getSenha());
            ps.setInt(4, paciente.getIdPaciente());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    /**
     * O metodo <strong>excluir</strong>, recebe um objeto por parametro, que vai ser o paciente, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idPaciente do object e coloca eles no preparedStatement, que usa a conexão para <strong>excluir</strong> o paciente na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String excluir(Object object) {
        paciente = (Paciente) object;
        String sql = "DELETE FROM ddd_paciente WHERE id_paci = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, paciente.getIdPaciente());
            if (ps.executeUpdate() > 0) {
                return "excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    /**
     * O metodo <strong>listar</strong>, recebe um objeto por parametro, que vai ser o paciente, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idPaciente do object e coloca eles no preparedStatement, que usa a conexão para <strong>listar</strong> o paciente da base de dados SQL para o usuário.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String listarUm(Object object) {
        paciente = (Paciente) object;
        String sql = "SELECT * FROM ddd_paciente WHERE id_paci = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, paciente.getIdPaciente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return String.format("ID: %s\nCPF: %s\nNome: %s\nSenha: %s", paciente.getIdPaciente(), rs.getString("cpf"), rs.getString("nm_paci"), rs.getString("senha"));
            } else {
                return "Registro não encontrado";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
