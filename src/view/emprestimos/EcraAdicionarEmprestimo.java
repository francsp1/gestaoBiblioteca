package view.emprestimos;

import model.DadosAplicacao;
import model.Emprestimo;
import model.Livro;
import model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class EcraAdicionarEmprestimo extends JFrame {
    private final EcraEmprestimos ecraPai;
    private JPanel painelEcraAdicionarEmprestimo;
    private JButton btnAdicionarEmprestimo;
    private JButton btnSair;
    private JComboBox cmbLivros;
    private JComboBox cmbSocios;
    private JLabel lblDataEmprestimo;
    private JLabel lblDataLimiteEntrega;

    public EcraAdicionarEmprestimo(EcraEmprestimos ecraPai) {
        super("Adicionar Empréstimo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraAdicionarEmprestimo);
        pack();

        this.ecraPai = ecraPai;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarEmprestimo.addActionListener(this::btnAdicionarEmprestimoActionPerformed);

        ArrayList<Livro> livros = DadosAplicacao.INSTANCIA.getLivrosDisponiveis();
        for (Livro livro: livros) {
            cmbLivros.addItem(livro);
        }

        ArrayList<Socio> socios = DadosAplicacao.INSTANCIA.getSociosAtivos();
        for (Socio socio: socios) {
            cmbSocios.addItem(socio);
        }

        if (livros.size() == 0 || socios.size() == 0) {
            btnAdicionarEmprestimo.setEnabled(false);
        }

        LocalDate now = LocalDate.now();
        lblDataEmprestimo.setText(now.toString());
        lblDataLimiteEntrega.setText(now.plusDays(15).toString());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnSairActionPerformed(ActionEvent event) {
        dispose();
    }

    private void btnAdicionarEmprestimoActionPerformed(ActionEvent event) {
        DadosAplicacao.INSTANCIA.adicionarEmprestimo(new Emprestimo((Livro) cmbLivros.getSelectedItem(), (Socio) cmbSocios.getSelectedItem()));
        dispose();
        ecraPai.preencherEmprestimos();
    }
}
