package br.com.fiap.model.dto;

import java.time.LocalDateTime;

public class Consulta {
    private int idConsulta;
    private int idCliente;
    private String nomeMed;
    private LocalDateTime horario;
    private String local;
    private String observacao;

    public Consulta() {}

    public int getIdConsulta() {
        return idConsulta;
    }
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeMed() {
        return nomeMed;
    }
    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public LocalDateTime getHorario() {
        return horario;
    }
    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
