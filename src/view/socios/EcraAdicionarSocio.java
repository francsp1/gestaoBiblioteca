package view.socios;

import javax.swing.*;

public class EcraAdicionarSocio extends JFrame{

    private final EcraSocios ecraPai;
    private JPanel painelEcraAdicionarSocio;
    private JButton btnAdicionarSocio;
    private JButton btnSair;
    private JLabel lblAdicionarSocio;
    private JPanel painelDetalhesSocio;

    public EcraAdicionarSocio(EcraSocios ecraPai) {
        super("Adicionar Socio");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraAdicionarSocio);
        pack();

        this.ecraPai = ecraPai;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarSocio.addActionListener(this::btnAdicionarSocioActionPerformed);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnAdicionarSocioActionPerformed(java.awt.event.ActionEvent evt) {

    }
}
