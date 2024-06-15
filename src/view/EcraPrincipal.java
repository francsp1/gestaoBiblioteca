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
        this.setVisible(false);
    }

    private void btnLivrosActionPerformed(ActionEvent actionEvent) {
        EcraLivros ecraLivros = new EcraLivros(this);
        this.setVisible(false);
    }
}
