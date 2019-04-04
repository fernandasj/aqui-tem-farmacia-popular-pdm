package ifpb.edu.br.appfarmaciapopular.model;

public class Medicamento {
    private Integer id;
    private String medicamento;
    private String indicacao;
    private String disponibilidade;

    public Medicamento(String[] line) {
        this.medicamento = line[0];
        this.indicacao = line[1];
        this.disponibilidade = line[2];
    }

    public Medicamento(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
