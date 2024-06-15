package model;

import java.util.ArrayList;

public class Livro {
    private static int contaIdFornecedores = 0;
    private int id;
    private int isbn;
    private String titulo;
    private ArrayList<String> autores;
    private String editora;
    private int edicao;
    private int ano;
    private int estante;
    private int prateleira;
    private String genero;
    private String subgenero;
    private boolean estado;

    public Livro(int isbn, String titulo, ArrayList<String> autores, String editora, int edicao, int ano, /*int estante, int prateleira,*/ String genero, String subgenero) {
        this.id = ++contaIdFornecedores;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.ano = ano;
        this.estante = -1;
        this.prateleira = -1;
        this.genero = genero;
        this.subgenero = subgenero;
        this.estado = false;
    }

    public Livro(int id, int isbn, String titulo, ArrayList<String> autores, String editora, int edicao, int ano, int estante, int prateleira, String genero, String subgenero) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.ano = ano;
        this.estante = estante;
        this.prateleira = prateleira;
        this.genero = genero;
        this.subgenero = subgenero;
        this.estado = true;
    }

    public static int getContaIdFornecedores() {
        return contaIdFornecedores;
    }

    public static void setContaIdFornecedores(int contaIdFornecedores) {
        Livro.contaIdFornecedores = contaIdFornecedores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(int prateleira) {
        this.prateleira = prateleira;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSubgenero() {
        return subgenero;
    }

    public void setSubgenero(String subgenero) {
        this.subgenero = subgenero;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}