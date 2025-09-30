package br.com.fiap.model.dao;


import br.com.fiap.model.dto.Receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe para criar objetos do tipo <strong>ReceitaDAO</strong> que implementa a interface <strong>IDAO</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ReceitaDAO implements IDAO{
    private Connection con;
    private Receita receita;

    public ReceitaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    /**
     * O metodo <strong>inserir</strong>, recebe um objeto por parametro, que vai ser a receita, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idPaciente, medicamento, prescricao do object e coloca eles no preparedStatement, que usa a conexão para <strong>inserir</strong> a receita na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da receita.
     */
    public String inserir(Object object) {
        receita = (Receita) object;
        String sql = "INSERT INTO ddd_receita(id_paci, medicamento, descricao) VALUES(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, receita.getIdPaciente());
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

    /**
     * O metodo <strong>alterar</strong>, recebe um objeto por parametro, que vai ser a receita, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega os atributos idPaciente, medicamento, prescricao e idReceita do object e coloca eles no preparedStatement, que usa a conexão para <strong>alterar</strong> a receita na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da receita.
     */
    public String alterar(Object object) {
        receita = (Receita) object;
        String sql = "UPDATE ddd_receita SET id_paci=?, medicamento=?, descricao=? WHERE id_receita = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, receita.getIdPaciente());
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

    /**
     * O metodo <strong>excluir</strong>, recebe um objeto por parametro, que vai ser a receita, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega o atributo idReceita do object e coloca eles no preparedStatement, que usa a conexão para <strong>excluir</strong> a receita na base de dados SQL.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da receita.
     */
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

    /**
     * O metodo <strong>listarUm</strong>, recebe um objeto por parametro, que vai ser a receita, e retorna uma mensagem de erro ou de sucesso.
     * Dentro do metodo ele pega o atributo idReceita do object e coloca eles no preparedStatement, que usa a conexão para <strong>listar</strong> a receita da base de dados SQL para o usuário.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param object é o objeto passado por parametro, que vai receber os valores da receita.
     */
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
