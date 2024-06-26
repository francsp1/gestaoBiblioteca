package model;

import java.time.LocalDate;

public class Socio {
    private static int contaIdSocios = 0;
    private int id;
    private String nome;
    private int NIF;
    private int cartaoCidadao;
    private String morada;
    private int telemovel;
    private String email;
    private MetodoComunicacaoPreferido metodoComunicacaoPreferido;
    private LocalDate dataCriacao;
    private LocalDate dataProximoPagamentoAnuidade;
    private boolean estado;
    private boolean multado;
    private boolean anuidadePaga;

    public Socio(String nome, int NIF, int cartaoCidadao,String morada, int telemovel, String email, MetodoComunicacaoPreferido metodoComunicacaoPreferido) {
        this.id = ++contaIdSocios;
        this.nome = nome;
        this.NIF = NIF;
        this.cartaoCidadao = cartaoCidadao;
        this.morada = morada;
        this.telemovel = telemovel;
        this.email = email;
        this.metodoComunicacaoPreferido = metodoComunicacaoPreferido;
        this.dataCriacao = LocalDate.now();
        this.dataProximoPagamentoAnuidade = LocalDate.of(1900, 1, 1);
        this.estado = true;
        this.multado = false;
        this.anuidadePaga = false;
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

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public int getCartaoCidadao() {
        return cartaoCidadao;
    }

    public void setCartaoCidadao(int cartaoCidadao) {
        this.cartaoCidadao = cartaoCidadao;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MetodoComunicacaoPreferido getMetodoComunicacaoPreferido() {
        return metodoComunicacaoPreferido;
    }

    public void setMetodoComunicacaoPreferido(MetodoComunicacaoPreferido metodoComunicacaoPreferido) {
        this.metodoComunicacaoPreferido = metodoComunicacaoPreferido;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataProximoPagamentoAnuidade() {
        return dataProximoPagamentoAnuidade;
    }

    public void setDataProximoPagamentoAnuidade(LocalDate dataProximoPagamentoAnuidade) {
        this.dataProximoPagamentoAnuidade = dataProximoPagamentoAnuidade;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isMultado() {
        return multado;
    }

    public void setMultado(boolean multado) {
        this.multado = multado;
    }

    public boolean isAnuidadePaga() {
        return anuidadePaga;
    }

    public void setAnuidadePaga(boolean anuidadePaga) {
        this.anuidadePaga = anuidadePaga;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome;
    }
}
