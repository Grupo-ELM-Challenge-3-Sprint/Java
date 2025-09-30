package br.com.fiap.model.dto;

/**
 * Classe para criar objetos do tipo <strong>Receita</strong>
 * @author Lucas Barros Gouveia
 * @author Enzo Okuizumi Miranda de Souza
 * @author Milton Jakson de Souza Marcelino
 * @version 1.0
 * @since 21.0.7
 */
public class Receita {
    private int idReceita;
    private int idPaciente;
    private String medicamento;
    private String prescricao;

    public Receita() {}

    public String getPrescricao() {
        return prescricao;
    }
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdReceita() {
        return idReceita;
    }
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }
}
