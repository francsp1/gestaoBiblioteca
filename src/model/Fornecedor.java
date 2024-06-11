package model;

public class Fornecedor {
    private int id;
    private String nome;
    private String distribuidor;
    private String Contacto;

    public Fornecedor(int id, String nome, String distribuidor, String contacto) {
        this.id = id;
        this.nome = nome;
        this.distribuidor = distribuidor;
        Contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }
}
