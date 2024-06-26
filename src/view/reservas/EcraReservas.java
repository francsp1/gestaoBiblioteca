package view.reservas;

import model.DadosAplicacao;

import model.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraReservas extends JFrame{
    private final JFrame parentFrame;
    private JPanel painelEcraReservas;
    private JButton criarReservaButton;
    private JButton sairButton;
    private JScrollPane ScrollPaneReservas;



    public EcraReservas(JFrame parentFrame) {
        super("Reservas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraReservas);
        pack();

        this.parentFrame = parentFrame;

        sairButton.addActionListener(this::sairButtonActionPerformed);
        criarReservaButton.addActionListener(this::criarReservaButtonActionPerformed);

        preencherReservas();

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void preencherReservas() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Reserva reserva : DadosAplicacao.INSTANCIA.getReservas()) {
            container.add(new PainelReserva(this, reserva), gbc);
        }

        ScrollPaneReservas.setViewportView(container);
    }

    private void sairButtonActionPerformed(ActionEvent actionEvent) {
        dispose();
        parentFrame.setVisible(true);
    }

    private void criarReservaButtonActionPerformed(ActionEvent actionEvent) {
        new EcraAdicionarReserva(this);
    }

}
