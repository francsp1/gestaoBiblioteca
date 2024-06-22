package view.socios;

import model.DadosAplicacao;
import model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraSocios extends JFrame{
    private final JFrame ecraPai;
    private JPanel painelEcraSocios;
    private JButton btnAdicionarSocio;
    private JButton btnSair;
    private JLabel lblSocios;
    private JScrollPane scrollPaneSocios;

    public EcraSocios(JFrame parent) {
        super("Livros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraSocios);
        pack();

        this.ecraPai = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);

        preencherSocios();

        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void preencherSocios() {
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

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        ecraPai.setVisible(true);
    }
}
