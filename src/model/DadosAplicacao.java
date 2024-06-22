package model;

import java.util.ArrayList;

public enum DadosAplicacao {
    INSTANCIA;

    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Socio> socios = new ArrayList<>();

    private DadosAplicacao() {
        Fornecedor fornecedor1 = new Fornecedor("PortoEditora", "DHL", "244 2444 244");
        Fornecedor fornecedor2 = new Fornecedor("Livros Horizonte", "DHL", "244 2444 244");
        Fornecedor fornecedor3 = new Fornecedor("Leya", "DHL", "244 2444 244");
        Fornecedor fornecedor4 = new Fornecedor("Bertrand", "DHL", "244 2444 244");
        Fornecedor fornecedor5 = new Fornecedor("Livraria Cultura", "DHL", "244 2444 244");

        adicionarFornecedor(fornecedor1);
        adicionarFornecedor(fornecedor2);
        adicionarFornecedor(fornecedor3);
        adicionarFornecedor(fornecedor4);
        adicionarFornecedor(fornecedor5);

        Livro livro1 = new Livro("123456789", "O Senhor dos Anéis", new ArrayList<String>() {{
            add("J.R.R. Tolkien");
        }}, "PortoEditora", 1, 1954, "Fantasia", "Alta Fantasia");
        Livro livro2 = new Livro("987654321", "O Principezinho", new ArrayList<String>() {{
            add("Antoine de Saint-Exupéry");
        }}, "PortoEditora", 1, 1943, "Infantil", "Infantil");
        Livro livro3 = new Livro("987654321", "Harry Potter e a Pedra Filosofal", new ArrayList<String>() {{
            add("J.K. Rowling");
        }}, "PortoEditora", 1, 1997, 10, 11, "Fantasia", "Fantasia Urbana");
        Livro livro4 = new Livro("123456789", "Os Lusíadas", new ArrayList<String>() {{
            add("Luís de Camões");
        }}, "PortoEditora", 1, 1556, 2, 3, "Épico", "Épico");
        //livro  com varios autores
        Livro livro6 = new Livro("123456789", "Classicos da Literatura", new ArrayList<String>() {{
            add("J.R.R. Tolkien");
            add("Antoine de Saint-Exupéry");
            add("J.K. Rowling");
            add("Luís de Camões");
        }}, "PortoEditora", 1, 1954, 20, 21, "Fantasia", "Alta Fantasia");

        adicionarLivro(livro1);
        adicionarLivro(livro2);
        adicionarLivro(livro3);
        adicionarLivro(livro4);
        adicionarLivro(livro6);

        Socio socio1 = new Socio("João", 123456789, "Rua do João", 912345678, "joao@mail.com", MetodoComunicacaoPreferido.EMAIL);
        Socio socio2 = new Socio("Maria", 987654321, "Rua da Maria", 912345678, "maria@mail.com", MetodoComunicacaoPreferido.EMAIL);
        Socio socio3 = new Socio("José", 123456789, "Rua do José", 912345678, "jose@mail.com", MetodoComunicacaoPreferido.EMAIL);
        Socio socio4 = new Socio("Ana", 987654321, "Rua da Ana", 912345678, "ana@mail.com", MetodoComunicacaoPreferido.SMS);
        Socio socio5 = new Socio("Manuel", 123456789, "Rua do Manuel", 912345678, "manuel@mail.com", MetodoComunicacaoPreferido.SMS);
        Socio socio6 = new Socio("Marta", 987654321, "Rua da Marta", 912345678, "marta@mail.com", MetodoComunicacaoPreferido.SMS);
        Socio socio7 = new Socio("Francisco", 987654321, "Rua da Francisco", 912345678, "francisco@mail.com", MetodoComunicacaoPreferido.EMAIL);

        adicionarSocio(socio1);
        adicionarSocio(socio2);
        adicionarSocio(socio3);
        adicionarSocio(socio4);
        adicionarSocio(socio5);
        adicionarSocio(socio6);
        adicionarSocio(socio7);
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void adicionarSocio(Socio socio) {
        socios.add(socio);
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public ArrayList<Socio> getSociosAtivos() {
        ArrayList<Socio> sociosAtivos = new ArrayList<>();
        for (Socio socio : socios) {
            if (socio.getEstado()) {
                sociosAtivos.add(socio);
            }
        }
        return socios;
    }

}
