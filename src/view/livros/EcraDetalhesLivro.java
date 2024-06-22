package view.livros;

import model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraDetalhesLivro extends JFrame {
    private static final String ERRO_1 = "Deve inserir os dados do livro.";
    private static final String ERRO_2 = "Deve inserir o título do livro.";
    private static final String ERRO_3 = "Deve inserir o ISBN do livro";
    private static final String ERRO_4 = "Deve inserir os autores do livro.";
    private static final String ERRO_5 = "Deve inserir a editora do livro.";
    private static final String ERRO_6 = "Deve inserir a edição do livro.";
    private static final String ERRO_7 = "Deve inserir o ano do livro.";
    private static final String ERRO_8 = "Deve inserir o género do livro.";
    private static final String ERRO_9 = "Deve inserir o subgénero do livro.";
    private static final String ERRO_10 = "Deve inserir a estante do livro.";
    private static final String ERRO_11 = "Deve inserir a prateleira do livro.";
    private static final String ERRO_12 = "A Edição do livro deve ser preenchida com um número inteiro.";
    private static final String ERRO_13 = "O Ano do livro deve ser preenchido com um número inteiro.";
    private static final String ERRO_14 = "A estante do livro deve ser preenchida com um número inteiro.";
    private static final String ERRO_15 = "A prateleira do livro deve ser preenchida com um número inteiro.";

    private final EcraLivros ecraPai;
    private final PainelLivro painelLivro;
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
    private JTextArea txtAutores;
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
    private JLabel lblEmprestadoPrefix;
    private JLabel lblEmprestado;
    private JLabel lblReservadoPrefix;
    private JLabel lblReservado;

    public EcraDetalhesLivro(EcraLivros ecraPai, PainelLivro painelLivro, Livro livro) {
        super("Detalhes do Fornecedor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesLivro);
        pack();

        this.ecraPai = ecraPai;
        this.painelLivro = painelLivro;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnEstado.addActionListener(e -> btnAlterarEstadoFornecedorActionPerformed(e, livro));

        preencherDetalhesLivro(livro);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherDetalhesLivro(Livro livro) {
        lblDetalhes.setText("Detalhes do Livro " + livro.getId());
        lblId.setText(String.valueOf(livro.getId()));
        txtISBN.setText(String.valueOf(livro.getIsbn()));
        txtTitulo.setText(livro.getTitulo());
        for (String autor : livro.getAutores()) {
            txtAutores.append(autor + "\n");
        }
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
            btnEstado.setText("Alterar Estado - Inativar Livro");
        } else {
            lblEstado.setText("Inativo");
            btnEstado.setText("Alterar Estado - Ativar Livro");
        }
        if (livro.isEmprestado()) {
            lblEmprestado.setText("Sim");
        } else {
            lblEmprestado.setText("Não");
        }
        if (livro.isReservado()) {
            lblReservado.setText("Sim");
        } else {
            lblReservado.setText("Não");
        }
    }

    private boolean validarDadosLivro() {
        if (txtTitulo.getText().trim().isEmpty() &&
                txtAutores.getText().trim().isEmpty() &&
                txtEditora.getText().trim().isEmpty() &&
                txtEdicao.getText().trim().isEmpty() &&
                txtAno.getText().trim().isEmpty() &&
                txtGenero.getText().trim().isEmpty() &&
                txtSubgenero.getText().trim().isEmpty()) {
            mostrarErro(ERRO_1);
            return false;
        } else if (txtTitulo.getText().trim().isEmpty()) {
            mostrarErro(ERRO_2);
            return false;
        } else if (txtISBN.getText().trim().isEmpty()) {
            mostrarErro(ERRO_3);
            return false;
        } else if (txtAutores.getText().trim().isEmpty()) {
            mostrarErro(ERRO_4);
            return false;
        } else if (txtEditora.getText().trim().isEmpty()) {
            mostrarErro(ERRO_5);
            return false;
        } else if (txtEdicao.getText().trim().isEmpty()) {
            mostrarErro(ERRO_6);
            return false;
        } else if (txtAno.getText().trim().isEmpty()) {
            mostrarErro(ERRO_7);
            return false;
        } else if (txtGenero.getText().trim().isEmpty()) {
            mostrarErro(ERRO_8);
            return false;
        } else if (txtSubgenero.getText().trim().isEmpty()) {
            mostrarErro(ERRO_9);
            return false;
        } else if (txtEstante.getText().trim().isEmpty()) {
            mostrarErro(ERRO_10);
            return false;
        } else if (txtPrateleira.getText().trim().isEmpty()) {
            mostrarErro(ERRO_11);
            return false;
        } else if (!txtEdicao.getText().trim().matches("\\d+")) {
            mostrarErro(ERRO_12);
            return false;
        } else if (!txtAno.getText().trim().matches("\\d+")) {
            mostrarErro(ERRO_13);
            return false;
        } else if (!txtEstante.getText().trim().matches("\\d+")) {
            mostrarErro(ERRO_14);
            return false;
        } else if (!txtPrateleira.getText().trim().matches("\\d+")) {
            mostrarErro(ERRO_15);
            return false;
        }

        return true;
    }

    private void atualizarDadosLivro(Livro livro) {
        livro.setTitulo(txtTitulo.getText());
        livro.setIsbn(txtISBN.getText());
        livro.getAutores().clear();
        for (String autor : txtAutores.getText().split("\n")) {
            if (!autor.trim().isEmpty()){
                livro.add(autor);
            }
        }
        livro.setEditora(txtEditora.getText());
        livro.setEdicao(Integer.parseInt(txtEdicao.getText()));
        livro.setAno(Integer.parseInt(txtAno.getText()));
        livro.setGenero(txtGenero.getText());
        livro.setSubgenero(txtSubgenero.getText());
        livro.setEstante(Integer.parseInt(txtEstante.getText()));
        livro.setPrateleira(Integer.parseInt(txtPrateleira.getText()));
    }

    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnAlterarEstadoFornecedorActionPerformed(ActionEvent e, Livro livro) {
        if (validarDadosLivro()) {
            atualizarDadosLivro(livro);
            if (livro.getEstado()) { // Se o livro está ativo
                livro.setEstado(false);
                lblEstado.setText("Inativo");
                btnEstado.setText("Alterar Estado - Ativar Livro");
            } else { // Se o livro está inativo
                livro.setEstado(true);
                lblEstado.setText("Ativo");
                btnEstado.setText("Alterar Estado - Inativar Livro");
            }

            painelLivro.preencherDetalhesLivro();
        }
    }
}
