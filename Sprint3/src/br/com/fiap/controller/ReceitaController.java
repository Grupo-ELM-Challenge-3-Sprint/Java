package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.ReceitaDAO;
import br.com.fiap.model.dto.Receita;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe para criar objetos do tipo <strong>ReceitaController</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class ReceitaController {
    /**
     * O metodo <strong>inserirReceita</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ReceitaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe receita e passa ele por parametro para o metodo inserir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ReceitaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idPaciente é o id do paciente passado por parametro.
     * @param medicamento é o medicamento da receita passado por parametro.
     * @param prescricao é a prescrição da receita passada por parametro.
     */
    public String inserirReceita(int idPaciente, String medicamento, String prescricao)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdPaciente(idPaciente);
        receita.setMedicamento(medicamento);
        receita.setPrescricao(prescricao);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.inserir(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    /**
     * O metodo <strong>alterarReceita</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ReceitaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe receita e passa ele por parametro para o metodo alterar. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ReceitaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idReceita é o id da receita passado por parametro.
     * @param idPaciente é o id do paciente passado por parametro.
     * @param medicamento é o medicamento da receita passado por parametro.
     * @param prescricao é a prescrição da receita passada por parametro.
     */
    public String alterarReceita(int idReceita, int idPaciente, String medicamento, String prescricao)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdReceita(idReceita);
        receita.setIdPaciente(idPaciente);
        receita.setMedicamento(medicamento);
        receita.setPrescricao(prescricao);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.alterar(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    /**
     * O metodo <strong>excluirReceita</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ReceitaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe receita e passa ele por parametro para o metodo excluir. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ReceitaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idReceita é o id da receita passado por parametro.
     */
    public String excluirReceita(int idReceita)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdReceita(idReceita);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.excluir(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    /**
     * O metodo <strong>listarUmaReceita</strong>, recebe os atributos do paciente por parametro, e retorna uma mensagem de erro ou de sucesso que vai obter do metodo da classe <strong>ReceitaDAO</strong>.
     * Dentro do metodo ele coloca os atributos no objeto da classe receita e passa ele por parametro para o metodo listarUm. Depois de receber o retorno do metodo, ele armazena e retorna para a classe <strong>ReceitaView</strong>
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param idReceita é o id da receita passado por parametro.
     */
    public String listarUmaReceita(int idReceita)
            throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Receita receita = new Receita();
        receita.setIdReceita(idReceita);

        ReceitaDAO receitaDAO = new ReceitaDAO(con);
        resultado  = receitaDAO.listarUm(receita);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
