package model;

public class Fornecedor {
    private static int contaId = 0;
    private int id;
    private String nome;
    private String distribuidor;
    private String contacto;

    private boolean ativo;

    public Fornecedor(String nome, String distribuidor, String contacto) {
        this.id = ++contaId;
        this.nome = nome;
        this.distribuidor = distribuidor;
        this.contacto = contacto;
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
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        contacto = contacto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
