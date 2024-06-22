package view.socios;

import model.Socio;
import view.common.Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelSocio extends Painel {
    private final Socio socio;
    private final JLabel lblId;
    private final JLabel lblNome;
    private final JLabel lblNIF;
    private final JLabel lblMorada;
    private final JLabel lblTelemovel;
    private final JLabel lblEmail;
    private final JButton btnDetalhes;

    protected PainelSocio(JFrame ecraPai, Socio socio) {
        super(ecraPai);

        this.socio = socio;

        lblId = new JLabel();
        lblNome = new JLabel();
        lblNIF = new JLabel();
        lblMorada = new JLabel();
        lblTelemovel = new JLabel();
        lblEmail = new JLabel();
        btnDetalhes = new JButton("Detalhes");

        preencherDetalhesSocio();

        desenharPainel();

        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, socio));
    }

    private void preencherDetalhesSocio() {
        lblId.setText("ID: " + socio.getId());
        lblNome.setText("Nome: " + socio.getNome());
        lblNIF.setText("NIF: " + socio.getNIF());
        lblMorada.setText("Morada: " + socio.getMorada());
        lblTelemovel.setText("Telemóvel: " + socio.getTelemovel());
        lblEmail.setText("Email: " + socio.getEmail());
    }

    private void desenharPainel() {
        setLayout(new GridLayout(7, 1));
        add(lblId);
        add(lblNome);
        add(lblNIF);
        add(lblMorada);
        add(lblTelemovel);
        add(lblEmail);
        add(btnDetalhes);
    }

    private void btnDetalhesActionPerformed(ActionEvent e, Socio socio) {

    }
}
