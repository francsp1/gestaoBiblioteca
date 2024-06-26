package view;

import model.DadosAplicacao;
import model.Fornecedor;
import view.encomenda.EcraEncomendas;
import view.fornecedores.EcraFornecedores;
import view.livros.EcraLivros;
import view.socios.EcraSocios;

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

    private EcraPrincipal(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnFornecedores.addActionListener(this::btnFornecedoresActionPerformed);
        btnLivros.addActionListener(this::btnLivrosActionPerformed);
        btnSocios.addActionListener(this::btnSociosActionPerformed);
        btnEncomendas.addActionListener(this::btnEncomendasActionPerformed);

        setLocationRelativeTo(null);
        setVisible(true);
    }




    public static void main(String[] args) {
        new EcraPrincipal("Menu Principal");
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void btnFornecedoresActionPerformed(ActionEvent actionEvent) {
        EcraFornecedores ecraFornecedores = new EcraFornecedores(this);
        setVisible(false);
    }

    private void btnLivrosActionPerformed(ActionEvent actionEvent) {
        EcraLivros ecraLivros = new EcraLivros(this);
        setVisible(false);
    }

    private void btnSociosActionPerformed(ActionEvent actionEvent) {
        EcraSocios ecraSocios = new EcraSocios(this);
        setVisible(false);
    }

    private void btnEncomendasActionPerformed(ActionEvent actionEvent) {
        EcraEncomendas ecraEncomendas = new EcraEncomendas(this);
        setVisible(false);
    }
}
