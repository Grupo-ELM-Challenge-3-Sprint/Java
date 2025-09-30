package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para criar objetos do tipo <strong>ConnectionFactory</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ConnectionFactory {
    /**
     * Metodo <strong>abrirConexao</strong> utilizado para realizar conexão com o banco de dados e criando a oportunidade para fazer operações CRUD
     * É necessário substituir <u>user.name</u> e <u>user.pass</u> por um usuário e senha para se conectar ao banco de dados e fazer a conexão.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @return Connection - retorna o resultado da conexão com o banco de dados SQL.;
     */
    public static Connection abrirConexao() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = "user.name";
            final String PASS = "";
            con = DriverManager.getConnection(url, USER, PASS);
            //System.out.println("Conexão aberta.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: A classe de conexão não foi encontrada!\n" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro de SQL!\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return con;
    }
    /**
     * Metodo <strong>fecharConexao</strong> utilizado para interromper conexão com o banco de dados após fazer operações CRUD
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param con - pega a conexão com o banco de dados por parametro e fecha ela.
     */
    public static void fecharConexao(Connection con) {
        try {
            con.close();
            //System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            System.out.println("Erro de SQL!\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
