package view.emprestimos;

import model.Emprestimo;
import view.common.Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelEmprestimo extends Painel {
    private final Emprestimo emprestimo;
    private final JLabel lblId;
    private final JLabel lblLivro;
    private final JLabel lblSocio;
    private final JLabel lblDataEmprestimo;
    private final JLabel lblDataEntrega;
    private final JButton btnDetalhes;

    protected PainelEmprestimo(EcraEmprestimos ecraPai, Emprestimo emprestimo) {
        super(ecraPai);

        this.emprestimo = emprestimo;

        lblId = new JLabel();
        lblLivro = new JLabel();
        lblSocio = new JLabel();
        lblDataEmprestimo = new JLabel();
        lblDataEntrega = new JLabel();
        btnDetalhes = new JButton();

        preencherDetalhesEmprestimo();

        desenharPainel();

        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, emprestimo));
    }

    private void preencherDetalhesEmprestimo() {
        lblId.setText("ID: " + emprestimo.getId());
        lblLivro.setText("Livro (ID e nome): " + emprestimo.getLivro().getId() + " - " + emprestimo.getLivro().getTitulo());
        lblSocio.setText("Sócio (ID e nome): " + emprestimo.getSocio().getId() + " - " + emprestimo.getSocio().getNome());
        lblDataEmprestimo.setText(emprestimo.getDataEmprestimo().toString());
        lblDataEntrega.setText((emprestimo.getDataEntrega() != null) ? emprestimo.getDataEntrega().toString() : "AINDA NÃO ENTREGUE");
        btnDetalhes.setText("Detalhes");
    }

    private void desenharPainel() {
        setLayout(new GridLayout(8, 1));
        add(lblId);
        add(lblLivro);
        add(lblSocio);
        add(lblDataEmprestimo);
        add(lblDataEntrega);
        add(btnDetalhes);
    }

    private void btnDetalhesActionPerformed(ActionEvent e, Emprestimo emprestimo) {
        EcraEmprestimos ecraPai = (EcraEmprestimos) this.ecraPai;
        new EcraDetalhesEmprestimo(ecraPai, emprestimo);
    }
}
