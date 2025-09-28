package br.com.fiap.model.dto;

/**
 * Classe para criar objetos do tipo <strong>Cliente</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class Cliente {
    private int idCliente;
    private String cpf;
    private String nome;
    private String senha;

    public Cliente() {}

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }
    /**
     * O setter "setCpf", recebe uma string por parametro que deve possuir 11 caracteres, caso contrário ele faz o tratamento de erro.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param cpf é o cpf do cliente passado por parametro.
     */
    public void setCpf(String cpf) {
        try {
            if (cpf.matches("^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$")) {
                this.cpf = cpf.replace(".", "").replace("-", "");
            } else {
                throw new Exception("cpf inválido! Deve possuir 11 caracteres.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getNome() {
        return nome;
    }
    /**
     * O setter "setNome", recebe uma string por parametro que deve possuir apenas letras, caso contrário ele faz o tratamento de erro.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param nome é o nome do cliente passado por parametro.
     */
    public void setNome(String nome) {
        try {
            if (nome.matches("^\\p{L}[\\p{L} \\-']*$")) {
                this.nome = nome;
            } else {
                throw new Exception("Nome inválido! Não use caracteres especiais ou números.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getSenha() {
        return senha;
    }
    /**
     * O setter "setSenha", recebe uma string por parametro que deve possuir entre 6 a 14 caracteres, caso contrário ele faz o tratamento de erro.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param senha é a senha passada por parametro.
     */
    public void setSenha(String senha) {
        try {
            if (senha.matches("^.{6,14}$")) {
                this.senha = senha;
            } else {
                throw new Exception("Senha incorreta! Deve possuir 6 a 14.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
