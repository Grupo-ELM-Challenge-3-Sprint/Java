package br.com.fiap.model.dto;

import java.time.LocalDateTime;

/**
 * Classe para criar objetos do tipo <strong>Consulta</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class Consulta {
    private int idConsulta;
    private int idPaciente;
    private String nomeMed;
    private LocalDateTime horario;
    private String endereco;
    private String observacao;

    public Consulta() {}

    public int getIdConsulta() {
        return idConsulta;
    }
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomeMed() {
        return nomeMed;
    }
    /**
     * O setter "setNomeMed", recebe uma string por parametro que deve possuir apenas letras, caso contrário ele faz o tratamento de erro.
     * @author Lucas Barros Gouveia
     * @author Enzo Okuizumi Miranda de Souza
     * @author Milton Jakson de Souza Marcelino
     * @param nomeMed é o nome do profissional da saúde passado por parametro.
     */
    public void setNomeMed(String nomeMed) {
        try {
            if (nomeMed.matches("^\\p{L}[\\p{L} \\-']*$")) {
                this.nomeMed = nomeMed;
            } else {
                throw new Exception("Nome inválido! Não use caracteres especiais ou números.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LocalDateTime getHorario() {
        return horario;
    }
    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
