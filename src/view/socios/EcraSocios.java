package view.socios;

import model.DadosAplicacao;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraSocios extends JFrame {
    private final JFrame ecraPai;
    private JPanel painelEcraEmprestimos;
    private JButton btnAdicionarEmprestimo;
    private JButton btnSair;
    private JLabel lblEmprestimos;
    private JScrollPane scrollPaneSocios;

    public EcraSocios(JFrame parent) {
        super("Livros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraEmprestimos);
        pack();

        this.ecraPai = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarEmprestimo.addActionListener(this::btnAdicionarSocioActionPerformed);

        preencherSocios();

        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    protected void preencherSocios() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Socio socio : DadosAplicacao.INSTANCIA.getSocios()) {
            container.add(new PainelSocio(this, socio), gbc);
        }

        scrollPaneSocios.setViewportView(container);
    }

    /*
    private void preencherSocios() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        for (Socio socio : DadosAplicacao.INSTANCIA.getSocios()) {
            container.add(new PainelSocio(this, socio));
        }

        scrollPaneSocios.setViewportView(container);
    }
     */

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        ecraPai.setVisible(true);
    }

    private void btnAdicionarSocioActionPerformed(ActionEvent actionEvent) {
        new EcraAdicionarSocio(this);
    }

}
