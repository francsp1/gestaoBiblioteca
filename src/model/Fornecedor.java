package model;

public class Fornecedor {
    private static int contaId = 0;
    private int id;
    private String nome;
    private String distribuidora;
    private String contacto;
    private boolean Estado;

    public Fornecedor(String nome, String distribuidor, String contacto) {
        this.id = ++contaId;
        this.nome = nome;
        this.distribuidora = distribuidor;
        this.contacto = contacto;
        this.Estado = true;
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

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        contacto = contacto;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }
}
