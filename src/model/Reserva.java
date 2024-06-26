package model;

import java.time.LocalDate;

public class Reserva {
    private static int contaIdReservas = 0;
    private int id;
    private String socio;
    private String titulo;
    private String autores;
    private LocalDate data;
    private boolean estado;

    public Reserva(int id, String socio, String titulo, String autores, LocalDate data, boolean estado) {
        this.id = id;
        this.socio = socio;
        this.titulo = titulo;
        this.autores = autores;
        this.data = data;
        this.estado = estado;
    }

    public Reserva(int id, String socio, String titulo, String autores, boolean estado) {
        this.id = id;
        this.socio = socio;
        this.titulo = titulo;
        this.autores = autores;
        this.estado = estado;
    }


    public static int getContaIdReservas() {
        return contaIdReservas;
    }

    public static void setContaIdReservas(int contaIdReservas) {
        Reserva.contaIdReservas = contaIdReservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
