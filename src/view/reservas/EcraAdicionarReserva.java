package view.reservas;

import model.DadosAplicacao;
import model.Reserva;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraAdicionarReserva extends JFrame {

    private static final String ERRO_1 = "Inserir todos os dados da encomenda";
    private static final String ERRO_2 = "Inserir o Socio.";
    private static final String ERRO_3 = "Inserir o Titulo";
    private static final String ERRO_4 = "Inserir o(s) Autor(es)";

    private final EcraReservas ecraPai;
    private JButton criarReservaButton;
    private JButton sairButton;
    private JTextField textFieldSocio;
    private JTextField textFieldTitulo;
    private JTextField textFieldAutores;
    private JLabel lblID;


    public EcraAdicionarReserva(EcraReservas ecraPai) {
        super("Detalhes do Reserva");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();

        this.ecraPai = ecraPai;

        sairButton.addActionListener(this::sairButtonActionPerformed);
        criarReservaButton.addActionListener(this::criarReservaButtonActionPerformed);


        setLocationRelativeTo(null);
        setVisible(true);
    }


    //funcoes
    private void inserirDadosReserva(Reserva reserva) {
        reserva.setSocio(textFieldSocio.getText());
        reserva.setTitulo(textFieldTitulo.getText());
        reserva.setAutores(textFieldAutores.getText());
    }


    private boolean validarDadosReserva() {
        if (textFieldSocio.getText().trim().isEmpty() && textFieldTitulo.getText().trim().isEmpty() &&
                textFieldAutores.getText().trim().isEmpty()) {
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


    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }

    //buttons
    private void sairButtonActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void criarReservaButtonActionPerformed(ActionEvent actionEvent) {
        if (validarDadosReserva()) {
            DadosAplicacao.INSTANCIA.adicionarReserva(new Reserva(Integer.valueOf(lblID.getText()),textFieldSocio.getText(), textFieldTitulo.getText(),
                    textFieldAutores.getText(), true));

            dispose();

            ecraPai.preencherReservas();
        }
    }
}
