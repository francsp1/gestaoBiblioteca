package model;

import java.time.LocalDate;

public class Emprestimo {
    private static int idCounter = 0;
    private int id;
    private Livro livro;
    private Socio socio;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;

    public Emprestimo(Livro livro, Socio socio) {
        this.id = ++idCounter;
        this.livro = livro;
        this.socio = socio;
        this.dataEmprestimo = LocalDate.now();

        livro.setEmprestado(true);
    }

    /*construtor para testagem (data custom)*/
    public Emprestimo(Livro livro, Socio socio, LocalDate dataEmprestimo) {
        this.id = ++idCounter;
        this.livro = livro;
        this.socio = socio;
        this.dataEmprestimo = dataEmprestimo;

        livro.setEmprestado(true);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Emprestimo.idCounter = idCounter;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
