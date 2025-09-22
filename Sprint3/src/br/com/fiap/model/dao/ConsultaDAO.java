package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ConsultaDAO implements IDAO {
    private Connection con;
    private Consulta consulta;

    public ConsultaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

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
