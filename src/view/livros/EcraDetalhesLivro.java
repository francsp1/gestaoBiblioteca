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
    private JTextField txtSubgenero;
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
        lblId.setText(String.valueOf(livro.getId()));
        txtISBN.setText(String.valueOf(livro.getIsbn()));
        txtTitulo.setText(livro.getTitulo());
        txtAutores.setText(livro.getAutoresString());
        txtEditora.setText(livro.getEditora());
        txtEdicao.setText(String.valueOf(livro.getEdicao()));
        txtAno.setText(String.valueOf(livro.getAno()));
        int estante = livro.getEstante();
        if (estante == Integer.MIN_VALUE) {
            txtEstante.setText("Não preenchido");
        } else {
            txtEstante.setText(String.valueOf(estante));
        }
        int prateleira = livro.getPrateleira();
        if (prateleira == Integer.MIN_VALUE) {
            txtPrateleira.setText("Não preenchido");
        } else {
            txtPrateleira.setText(String.valueOf(prateleira));
        }
        txtGenero.setText(livro.getGenero());
        txtSubgenero.setText(livro.getSubgenero());
        if (livro.getEstado()) {
            lblEstado.setText("Ativo");
        } else {
            lblEstado.setText("Inativo");
        }

    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnAlterarEstadoFornecedorActionPerformed(ActionEvent e, Livro livro) {


    }
}
