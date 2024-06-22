package view.socios;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraSocios extends JFrame{
    private final JFrame ecraPai;
    private JPanel painelEcraSocios;
    private JButton btnAdicionarSocio;
    private JButton btnSair;
    private JLabel lblSocios;

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
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        ecraPai.setVisible(true);
    }
}
