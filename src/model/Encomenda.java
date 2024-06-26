package model;

public class Encomenda {
    private static int contaIdEncomendas = 0;
    private int id;
    private String livro;
    private String fornecedor;
    private String isbn;
    private int n_unidades;
    private boolean estado;

    //construtor
    public Encomenda(String livro, String fornecedor, String isbn, int n_unidades) {
        this.id = ++contaIdEncomendas;
        this.livro = livro;
        this.fornecedor = fornecedor;
        this.isbn = isbn;
        this.n_unidades = n_unidades;
    }

    public void registarRecibo(){

    }

    //getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLivro() { return livro; }
    public void setLivro(String livro) { this.livro = livro; }
    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getN_unidades() { return n_unidades; }
    public void setN_unidades(int n_unidades) { this.n_unidades = n_unidades; }
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }



}
