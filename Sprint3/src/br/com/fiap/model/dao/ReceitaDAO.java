package br.com.fiap.model.dao;


import br.com.fiap.model.dto.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class ReceitaDAO implements IDAO{
    private Connection con;
    private Receita receita;

    public ReceitaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
        receita = (Receita) object;
        String sql = "INSERT INTO ddd_receita(id_cliente, medicamento, descricao) VALUES(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, receita.getIdCliente());
            ps.setString(2, receita.getMedicamento());
            ps.setString(3, receita.getPrescricao());
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
        receita = (Receita) object;
        String sql = "UPDATE ddd_receita SET id_cliente=?, medicamento=?, descricao=? WHERE id_receita = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, receita.getIdCliente());
            ps.setString(2, receita.getMedicamento());
            ps.setString(3, receita.getPrescricao());
            ps.setInt(4, receita.getIdReceita());
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
        receita = (Receita) object;
        String sql = "DELETE FROM ddd_receita WHERE id_receita = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, receita.getIdReceita());
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
        receita = (Receita) object;
        String sql = "SELECT FROM ddd_receita WHERE id_receita = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, receita.getIdReceita());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return String.format("Medicamento: %s\nPrescrição: %s", receita.getMedicamento(), receita.getPrescricao());
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
