package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 * Classe para criar objetos do tipo <strong>ConsultaDAO</strong> que implementa a interface <strong>IDAO</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ConsultaDAO implements IDAO {
    private Connection con;
    private Consulta consulta;

    public ConsultaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    /**
     * O metodo <strong>inserir</strong>, recebe um objeto por parametro, que vai ser a consulta, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idCliente, nomeMed, horario, local, observacao do object e coloca eles no preparedStatement, que usa a conexão para <strong>inserir</strong> a consulta na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String inserir(Object object) {
        consulta = (Consulta) object;
        String sql = "INSERT INTO ddd_consulta(id_cliente, nome_med, horario, local, observacao) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdCliente());
            ps.setString(2, consulta.getNomeMed());
            ps.setString(3, consulta.getHorario().toString());
            ps.setString(4, consulta.getLocal());
            ps.setString(5, consulta.getObservacao());
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
     * O metodo <strong>alterar</strong>, recebe um objeto por parametro, que vai ser a consulta, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idConsulta, idCliente, nomeMed, horario, local, observacao do object e coloca eles no preparedStatement, que usa a conexão para <strong>alterar</strong> a consulta na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String alterar(Object object) {
        consulta = (Consulta) object;
        String sql = "UPDATE ddd_consulta SET id_cliente=?, nome_med=?, horario=?, local=?, observacao=? WHERE id_consulta = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdCliente());
            ps.setString(2, consulta.getNomeMed());
            ps.setString(3, consulta.getHorario().toString());
            ps.setString(4, consulta.getLocal());
            ps.setString(5, consulta.getObservacao());
            ps.setInt(6, consulta.getIdConsulta());

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
     * O metodo <strong>excluir</strong>, recebe um objeto por parametro, que vai ser a consulta, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idConsulta do object e coloca eles no preparedStatement, que usa a conexão para <strong>excluir</strong> a consulta na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String excluir(Object object) {
        consulta = (Consulta) object;
        String sql = "DELETE FROM ddd_consulta WHERE id_consulta = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdConsulta());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao exluir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    /**
     * O metodo <strong>listarUm</strong>, recebe um objeto por parametro, que vai ser a consulta, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idConsulta do object e coloca eles no preparedStatement, que usa a conexão para <strong>listar</strong> a consulta da base de dados SQL para o usuário.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da consulta.
     */
    public String listarUm(Object object) {
        consulta = (Consulta) object;
        String sql = "SELECT FROM ddd_consulta WHERE id_consulta = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdConsulta());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return String.format("Nome do profissional de saúde: %s\nHorário: %s\nLocal: %s\nObservação: %s", consulta.getNomeMed(), consulta.getHorario().format(dtf), consulta.getLocal(), consulta.getObservacao());
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
