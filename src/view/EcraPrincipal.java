package view;

import model.DadosAplicacao;
import model.Fornecedor;
import view.fornecedores.EcraFornecedores;
import view.livros.EcraLivros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcraPrincipal extends JFrame {

    private JPanel painelPrincipal;
    private JButton btnSocios;
    private JButton btnFornecedores;
    private JButton btnReservas;
    private JButton btnLivros;
    private JButton btnEmprestimos;
    private JButton btnPagamentos;
    private JButton btnEncomendas;
    private JButton btnSair;

    public EcraPrincipal(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnFornecedores.addActionListener(this::btnFornecedoresActionPerformed);
        btnLivros.addActionListener(this::btnLivrosActionPerformed);

        Fornecedor fornecedor1 = new Fornecedor("PortoEditora", "DHL", "244 2444 244");
        Fornecedor fornecedor2 = new Fornecedor("Livros Horizonte", "DHL", "244 2444 244");
        Fornecedor fornecedor3 = new Fornecedor("Leya", "DHL", "244 2444 244");
        Fornecedor fornecedor4 = new Fornecedor("Bertrand", "DHL", "244 2444 244");
        Fornecedor fornecedor5 = new Fornecedor("Livraria Cultura", "DHL", "244 2444 244");

        DadosAplicacao.INSTANCIA.adicionarFornecedor(fornecedor1);
        DadosAplicacao.INSTANCIA.adicionarFornecedor(fornecedor2);
        DadosAplicacao.INSTANCIA.adicionarFornecedor(fornecedor3);
        DadosAplicacao.INSTANCIA.adicionarFornecedor(fornecedor4);
        DadosAplicacao.INSTANCIA.adicionarFornecedor(fornecedor5);
    }



    public static void main(String[] args) {
        new EcraPrincipal("Ecrã Principal").setVisible(true);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void btnFornecedoresActionPerformed(ActionEvent e) {
        EcraFornecedores ecraFornecedores = new EcraFornecedores("Ecrã Fornecedores", this);
        this.setVisible(false);
    }

    private void btnLivrosActionPerformed(ActionEvent actionEvent) {
        EcraLivros ecraLivros = new EcraLivros("Ecrã Livros", this);
        this.setVisible(false);
    }
}
