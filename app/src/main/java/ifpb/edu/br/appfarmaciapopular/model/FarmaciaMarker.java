package ifpb.edu.br.appfarmaciapopular.model;

public class FarmaciaMarker {
    private Integer id;
    private String latitude;
    private String longitude;
    private String endereco;
    private String nome;

    public FarmaciaMarker() {
    }

    public FarmaciaMarker(Integer id, String latitude, String longitude, String endereco, String nome) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
        this.nome = nome;
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

    public Double getLat() {
        return Double.valueOf(latitude.replace("\"", ""));
    }

    public Double getLng() {
        return Double.valueOf(longitude.replace("\"", ""));
    }
}
