package view.reservas;

import model.Reserva;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraDetalhesReserva extends JFrame{

    private static final String ERRO_1 = "Inserir todos os dados da encomenda";
    private static final String ERRO_2 = "Inserir o Socio.";
    private static final String ERRO_3 = "Inserir o Titulo";
    private static final String ERRO_4 = "Inserir o(s) Autor(es)";


    private final EcraReservas ecraPai;
    private final PainelReserva painelReserva;
    private JPanel painelEcraDetalhesReserva;
    private JLabel lblDetalhes;
    private JButton verDetalhesDoLivroButton;
    private JButton estadoButton;
    private JButton confirmarButton;
    private JButton sairButton;
    private JLabel lblEstado;
    private JTextField textFieldData;
    private JTextField textFieldAutores;
    private JTextField textFieldTitulo;
    private JTextField textFieldSocio;




    public EcraDetalhesReserva(EcraReservas ecraPai, PainelReserva painelReserva, Reserva reserva) {
        super("Detalhes do Encomenda");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesReserva);
        pack();

        this.ecraPai = ecraPai;
        this.painelReserva = painelReserva;

        sairButton.addActionListener(this::sairButtonActionPerformed);
        estadoButton.addActionListener(e -> btnAlterarEstadoReservaActionPerformed(e, reserva));

        preencherDetalhesReserva(reserva);

        setLocationRelativeTo(null);
        setVisible(true);
    }



    //funcoes
    private void preencherDetalhesReserva(Reserva reserva) {
        lblDetalhes.setText("Detalhes Encomenda " + reserva.getId());
        textFieldSocio.setText(String.valueOf(reserva.getSocio()));
        textFieldTitulo.setText(String.valueOf(reserva.getTitulo()));
        textFieldAutores.setText(reserva.getAutores());
        textFieldData.setText(String.valueOf(reserva.getData()));
        if (reserva.getEstado()) {
            lblEstado.setText("Ativo");
            estadoButton.setText("Alterar Estado - Inativar Livro");
        } else {
            lblEstado.setText("Inativo");
            estadoButton.setText("Alterar Estado - Ativar Livro");
        }
    }



    private boolean validarDadosReserva() {
        if (textFieldSocio.getText().trim().isEmpty() && textFieldTitulo.getText().trim().isEmpty() &&
                textFieldAutores.getText().trim().isEmpty() && textFieldData.getText().trim().isEmpty()) {
            mostrarErro(ERRO_1);
            return false;
        } else if (textFieldSocio.getText().trim().isEmpty()) {
            mostrarErro(ERRO_2);
            return false;
        } else if (textFieldTitulo.getText().trim().isEmpty()) {
            mostrarErro(ERRO_3);
            return false;
        } else if (textFieldAutores.getText().trim().isEmpty()) {
            mostrarErro(ERRO_4);
            return false;
        }
        return true;
    }

    private void atualizarDadosReserva(Reserva reserva) {
        reserva.setSocio(textFieldSocio.getText());
        reserva.setTitulo(textFieldTitulo.getText());
        reserva.setAutores(textFieldAutores.getText());
    }


    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }

    //buttons
    private void sairButtonActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnAlterarEstadoReservaActionPerformed(ActionEvent e, Reserva reserva) {
        if (validarDadosReserva()) {
            atualizarDadosReserva(reserva);
            if (reserva.getEstado()) { // Se o encomenda está ativa
                reserva.setEstado(false);
                lblEstado.setText("Inativo");
                estadoButton.setText("Alterar Estado - Ativar Encomenda");
            } else { // Se o encomenda está inativa
                reserva.setEstado(true);
                lblEstado.setText("Ativo");
                estadoButton.setText("Alterar Estado - Inativar Encomenda");
            }

            painelReserva.preencherDetalhesReserva();
        }
    }



}
