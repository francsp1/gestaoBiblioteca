package model;

public class Socio {
    private static int contaIdSocios = 0;
    private int id;
    private String nome;
    private int NIF;
    private String morada;
    private int telemovel;
    private String email;
    private MetodoComunicacaoPreferido metodoComunicacaoPreferido;
    private boolean estado;
    private boolean multado;
    private boolean anuidadePaga;

    public Socio(String nome, int NIF, String morada, int telemovel, String email, MetodoComunicacaoPreferido metodoComunicacaoPreferido) {
        this.id = ++contaIdSocios;
        this.nome = nome;
        this.NIF = NIF;
        this.morada = morada;
        this.telemovel = telemovel;
        this.email = email;
        this.metodoComunicacaoPreferido = metodoComunicacaoPreferido;
        this.estado = true;
        this.multado = false;
        this.anuidadePaga = false;
    }

    public static int getContaIdSocios() {
        return contaIdSocios;
    }

    public static void setContaIdSocios(int contaIdSocios) {
        Socio.contaIdSocios = contaIdSocios;
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
}
