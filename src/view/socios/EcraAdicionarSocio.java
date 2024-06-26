package view.socios;

import model.DadosAplicacao;
import model.MetodoComunicacaoPreferido;
import model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraAdicionarSocio extends JFrame {

    private static final String ERRO_1 = "Deve inserir os dados do socio antes de o adicionar.";
    private static final String ERRO_2 = "Deve inserir o nome do sócio antes de o adicionar.";
    private static final String ERRO_3 = "Deve inserir o NIF do sócio antes de o adicionar.";
    private static final String ERRO_4 = "Deve inserir o número de Cartão de Cidadão do socio antes de o adicionar.";
    private static final String ERRO_5 = "Deve inserir a morada do socio antes de o adicionar.";
    private static final String ERRO_6 = "Deve inserir o telemovel do socio antes de o adicionar.";
    private static final String ERRO_7 = "NIF Invalido.";
    private static final String ERRO_8 = "Já existe um sócio com o NIF inserido.";
    private static final String ERRO_9 = "Número de Cartão de Cidadão Invalido.";
    private static final String ERRO_10 = "Já existe um sócio com o número de Cartão de Cidadão inserido.";
    private static final String ERRO_11 = "Telemóvel Invalido.";
    private final EcraSocios ecraPai;
    private JPanel painelEcraAdicionarSocio;
    private JButton btnAdicionarSocio;
    private JButton btnSair;
    private JLabel lblAdicionarSocio;
    private JPanel painelDetalhesSocio;
    private JLabel lblNome;
    private JTextField txtNome;
    private JTextField txtNif;
    private JLabel lblNif;
    private JTextField txtMorada;
    private JLabel lblMorada;
    private JTextField txtTelemovel;
    private JLabel lblTelemovel;
    private JLabel lblMetodoComunicacaoPreferido;
    private JComboBox cmbMetodoComunicacaoPreferido;
    private JTextField txtCartaoCidadao;
    private JLabel lblCartaoCidadao;
    private JLabel lblEmail;
    private JTextField txtEmail;

    public EcraAdicionarSocio(EcraSocios ecraPai) {
        super("Adicionar Socio");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraAdicionarSocio);
        pack();

        this.ecraPai = ecraPai;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarSocio.addActionListener(this::btnAdicionarSocioActionPerformed);

        preencherDetalhes();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherDetalhes() {
        cmbMetodoComunicacaoPreferido.setModel(new DefaultComboBoxModel(MetodoComunicacaoPreferido.values()));
    }

    private boolean validarDadosSocio() {
        if (txtNome.getText().trim().isEmpty() &&
                txtNif.getText().trim().isEmpty() &&
                txtCartaoCidadao.getText().trim().isEmpty() &&
                txtMorada.getText().trim().isEmpty() &&
                txtTelemovel.getText().trim().isEmpty()) {
            mostrarErro(ERRO_1);
            return false;
        } else if (txtNome.getText().trim().isEmpty()) {
            mostrarErro(ERRO_2);
            return false;
        } else if (txtNif.getText().trim().isEmpty()) {
            mostrarErro(ERRO_3);
            return false;
        } else if (txtCartaoCidadao.getText().trim().isEmpty()) {
            mostrarErro(ERRO_4);
            return false;
        } else if (txtMorada.getText().trim().isEmpty()) {
            mostrarErro(ERRO_5);
            return false;
        } else if (txtTelemovel.getText().trim().isEmpty()) {
            mostrarErro(ERRO_6);
            return false;
        } else if (!validarNif(txtNif.getText())) {
            mostrarErro(ERRO_7);
            return false;
        } else if (!DadosAplicacao.INSTANCIA.isNifUnico(Integer.parseInt(txtNif.getText()))) {
            mostrarErro(ERRO_8);
            return false;
        } else if (!validarCartaoCidadao(txtCartaoCidadao.getText())) {
            mostrarErro(ERRO_9);
            return false;
        } else if (!DadosAplicacao.INSTANCIA.isCartaoCidadaoUnico(Integer.parseInt(txtCartaoCidadao.getText()))) {
            mostrarErro(ERRO_10);
            return false;
        } else if (!validarTelemovel(txtTelemovel.getText())) {
            mostrarErro(ERRO_11);
            return false;
        }
        return true;
    }

    private boolean validarNif(String nif) {
        return nif.matches("[0-9]{9}");
    }

    private boolean validarTelemovel(String telemovel) {
        return telemovel.matches("[0-9]{9}");
    }

    private boolean validarCartaoCidadao(String cartaoCidadao) {
        return cartaoCidadao.matches("[0-9]{8}");
    }

    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }


    private void btnSairActionPerformed(ActionEvent event) {
        dispose();
    }

    private void btnAdicionarSocioActionPerformed(ActionEvent event) {
        if (validarDadosSocio()) {
            DadosAplicacao.INSTANCIA.adicionarSocio(new Socio(txtNome.getText(), Integer.parseInt(txtNif.getText()), Integer.parseInt(txtCartaoCidadao.getText()), txtMorada.getText(), Integer.parseInt(txtTelemovel.getText()), txtEmail.getText(), (MetodoComunicacaoPreferido) cmbMetodoComunicacaoPreferido.getSelectedItem()));

            dispose();

            ecraPai.preencherSocios();
        }
    }
}
