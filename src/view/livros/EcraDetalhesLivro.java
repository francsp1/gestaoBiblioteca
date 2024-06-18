package view.livros;

import model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraDetalhesLivro extends JFrame {
    private final EcraLivros ecraPai;
    private JPanel painelEcraDetalhesLivro;
    private JButton btnConfirmar;
    private JButton btnSair;
    private JButton btnEstado;
    private JLabel lblDetalhes;
    private JPanel painelDetalhesLivro;
    private JLabel lblIdPrefix;
    private JLabel lblId;
    private JTextField txtISBN;
    private JLabel lbl;
    private JTextField txtTitulo;
    private JLabel lblTitulo;
    private JLabel lblEstadoPrefix;
    private JLabel lblEstado;
    private JTextField txtAutores;
    private JTextField txtEditora;
    private JLabel lblAutores;
    private JLabel lblEditora;
    private JTextField txtEdicao;
    private JLabel lblEdicao;
    private JTextField txtAno;
    private JLabel lblAno;
    private JTextField txtEstante;
    private JTextField txtPrateleira;
    private JLabel lblGenero;
    private JTextField textField1;
    private JTextField txtGenero;

    public EcraDetalhesLivro(EcraLivros ecraPai, Livro livro) {
        super("Detalhes do Fornecedor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesLivro);
        pack();

        this.ecraPai = ecraPai;


        btnSair.addActionListener(this::btnSairActionPerformed);
        btnEstado.addActionListener(e -> btnAlterarEstadoFornecedorActionPerformed(e, livro));

        preencherDetalhesLivro(livro);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void preencherDetalhesLivro(Livro livro) {
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnAlterarEstadoFornecedorActionPerformed(ActionEvent e, Livro livro) {


    }
}
