package view.emprestimos;

import model.Emprestimo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class EcraDetalhesEmprestimo extends JFrame {
    private final EcraEmprestimos ecraPai;
    private JPanel painelEcraDetalhesEmprestimo;
    private JButton btnSair;
    private JButton btnDevolverEmprestimo;
    private JLabel lblDetalhes;
    private JLabel lblLivro;
    private JLabel lblSocio;
    private JLabel lblDataEmprestimo;
    private JLabel lblDataEntrega;
    private JButton btnConfirmar;
    private LocalDate dataEntregaNaoConfirmada;

    public EcraDetalhesEmprestimo(EcraEmprestimos ecraPai, Emprestimo emprestimo) {
        super("Detalhes do Fornecedor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesEmprestimo);
        pack();

        this.ecraPai = ecraPai;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnDevolverEmprestimo.addActionListener(e -> btnDevolverEmprestimoActionPerformed(e, emprestimo));
        btnConfirmar.addActionListener(e -> btnConfirmarActionPerformed(e, emprestimo));

        preencherDetalhesEmprestimo(emprestimo);

        if (emprestimo.getDataEntrega() != null) {
            btnDevolverEmprestimo.setEnabled(false);
        }

        setLocationRelativeTo(null);
        setVisible(true);

    }


    private void preencherDetalhesEmprestimo(Emprestimo emprestimo) {
        lblDetalhes.setText("Detalhes do Empréstimo " + emprestimo.getId());

        lblLivro.setText(emprestimo.getLivro().getId() + " - " + emprestimo.getLivro().getTitulo());
        lblSocio.setText(emprestimo.getSocio().getId() + " - " + emprestimo.getSocio().getNome());
        lblDataEmprestimo.setText(emprestimo.getDataEmprestimo().toString());
        lblDataEntrega.setText((emprestimo.getDataEntrega() != null) ? emprestimo.getDataEntrega().toString() : "AINDA NÃO ENTREGUE");
    }


    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnDevolverEmprestimoActionPerformed(ActionEvent actionEvent, Emprestimo emprestimo) {
        btnDevolverEmprestimo.setEnabled(false);
        LocalDate now = LocalDate.now();
        this.dataEntregaNaoConfirmada = now;
        lblDataEntrega.setText(now.toString());
    }

    private void btnConfirmarActionPerformed(ActionEvent actionEvent, Emprestimo emprestimo) {
        emprestimo.setDataEntrega(this.dataEntregaNaoConfirmada);
        emprestimo.getLivro().setEmprestado(false);
        long numeroDiasDesdeEmprestimo = DAYS.between(emprestimo.getDataEmprestimo(), this.dataEntregaNaoConfirmada);
        if (numeroDiasDesdeEmprestimo > 15) {
            emprestimo.getSocio().setMultado(true);
            //TODO: usar este valor da multa...
            float multa = (numeroDiasDesdeEmprestimo - 15) * 0.5f;
        }
        ecraPai.preencherEmprestimos();
    }
}
