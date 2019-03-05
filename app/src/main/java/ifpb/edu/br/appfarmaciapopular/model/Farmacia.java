package ifpb.edu.br.appfarmaciapopular.model;

public class Farmacia {

    private Integer id;
    private String latitude;
    private String longitude;
    private String ddd;
    private String telefone;
    private String cep;
    private String bairro;
    private String endereco;
    private String nome;
    private String cidade;
    private String uf;

    public Farmacia(String[] line) {
        this.latitude = line[0];
        this.longitude = line[1];
        this.ddd = line[2];
        this.telefone = line[3];
        this.cep = line[4];
        this.bairro = line[5];
        this.endereco = line[6];
        this.nome = line[7];
        this.cidade = line[8];
        this.uf = line[9];
    }

    public Farmacia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
