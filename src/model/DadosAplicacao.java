package model;

import java.util.ArrayList;

public enum DadosAplicacao {
    INSTANCIA;

    private ArrayList<Fornecedor> fornecedores;

     DadosAplicacao() {
        this.fornecedores = new ArrayList<>();
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
    }

    public void adicionarFornecedor(Fornecedor fornecedor){
        fornecedores.add(fornecedor);
    }

    public ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }

}
