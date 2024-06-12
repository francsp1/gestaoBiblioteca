package model;

import java.util.ArrayList;

public enum DadosAplicacao {
    INSTANCIA;

    private ArrayList<Fornecedor> fornecedores;

    DadosAplicacao() {
        this.fornecedores = new ArrayList<>();
    }

    public void adicionarFornecedor(Fornecedor fornecedor){
        fornecedores.add(fornecedor);
    }

    public ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }

}
