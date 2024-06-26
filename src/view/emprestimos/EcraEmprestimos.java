package view.emprestimos;

import model.DadosAplicacao;
import model.Emprestimo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraEmprestimos extends JFrame {
    private final JFrame ecraPai;
    private JPanel painelEcraEmprestimos;
    private JButton btnAdicionarEmprestimo;
    private JButton btnSair;
    private JScrollPane scrollPaneEmprestimos;

    public EcraEmprestimos(JFrame parent) {
        super("Empréstimos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraEmprestimos);
        pack();

        this.ecraPai = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarEmprestimo.addActionListener(this::btnAdicionarEmprestimoActionPerformed);

        preencherEmprestimos();

        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    protected void preencherEmprestimos() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Emprestimo emprestimo : DadosAplicacao.INSTANCIA.getEmprestimos()) {
            container.add(new PainelEmprestimo(this, emprestimo), gbc);
        }

        scrollPaneEmprestimos.setViewportView(container);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        ecraPai.setVisible(true);
    }

    private void btnAdicionarEmprestimoActionPerformed(ActionEvent actionEvent) {
        new EcraAdicionarEmprestimo(this);
    }
}
