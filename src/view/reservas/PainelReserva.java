package view.reservas;

import model.Reserva;
import view.common.Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelReserva extends Painel{
    private final Reserva reserva;
    private final JLabel lblId;
    private final JLabel lblSocio;
    private final JLabel lblTitulo;
    private final JLabel lblAutores;
    private final JLabel lblData;
    private final JLabel lblEstado;
    private final JButton btnDetalhes;

    public PainelReserva(EcraReservas ecraPai,Reserva reserva){
        super(ecraPai);

        this.reserva = reserva;

        lblId = new JLabel();
        lblSocio = new JLabel();
        lblTitulo = new JLabel();
        lblAutores = new JLabel();
        lblData = new JLabel();
        lblEstado = new JLabel();
        btnDetalhes = new JButton();

        preencherDetalhesReserva();

        desenharPainel();

        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, this ,reserva));

    }

    public void preencherDetalhesReserva() {
        lblId.setText("ID: " + reserva.getId());
        lblSocio.setText("Nome: " + reserva.getSocio());
        lblTitulo.setText("Distribuidora: " + reserva.getTitulo());
        lblAutores.setText("Contacto: "+ reserva.getAutores());
        lblData.setText("Contacto: "+ reserva.getData());
        StringBuilder estado = new StringBuilder();
        estado.append("Estado: ");
        if (reserva.getEstado()) {
            estado.append("Ativo");
            setBackGroundVerde();
        }else {
            estado.append("Inativo");
            setBackGroundVermelho();
        }
        lblEstado.setText(estado.toString());
        btnDetalhes.setText("Detalhes");
    }

    private void desenharPainel() {
        setLayout(new GridLayout(7, 1)); // Adjust layout as needed
        add(lblId);
        add(lblSocio);
        add(lblTitulo);
        add(lblAutores);
        add(lblData);
        add(lblEstado);
        add(btnDetalhes);
    }

    private void btnDetalhesActionPerformed(ActionEvent actionEvent, PainelReserva painelReserva, Reserva reserva) {
        EcraReservas ecraPai = (EcraReservas) this.ecraPai;
        new EcraDetalhesReserva(ecraPai, painelReserva, reserva);
    }
}

