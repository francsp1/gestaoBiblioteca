package view.socios;

import model.DadosAplicacao;
import model.MetodoComunicacaoPreferido;
import model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraDetalhesSocio extends JFrame {

    private EcraSocios ecraPai;
    private PainelSocio painelSocio;
    private JPanel painelEcraDetalhesSocio;
    private JLabel lblIdPrefix;
    private JLabel lblId;
    private JLabel lblEstadoPrefix;
    private JLabel lblEstado;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblNif;
    private JTextField txtNif;
    private JTextField txtCartaoCidadao;
    private JLabel lblCartaoCidadao;
    private JTextField txtMorada;
    private JLabel lblMorada;
    private JLabel lblTelemovel;
    private JTextField txtTelemovel;
    private JTextField txtEmail;
    private JLabel lblEmail;
    private JTextField txtMetodoComunicacaoPreferido;
    private JLabel lblMetodoComunicacaoPreferico;
    private JLabel lblDataCriacaoPrefix;
    private JLabel lblDataPagamentoProximaAnuidadePrefix;
    private JLabel lblDataCriacao;
    private JLabel lblDataPagamentoProximaAnuidade;
    private JLabel lblMultadoPrefix;
    private JLabel lblAnuidadePagaPrefix;
    private JLabel lblMultado;
    private JLabel lblAnuidadePaga;
    private JButton button1;
    private JButton btnSair;
    private JButton btnEstado;
    private JLabel lblDetalhes;
    private JComboBox cmbMetodoComunicacaoPreferido;

    public EcraDetalhesSocio(EcraSocios ecraPai, PainelSocio painelSocio, Socio socio) {
        super("Detalhes do Sócio");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesSocio);
        pack();

        this.ecraPai = ecraPai;
        this.painelSocio = painelSocio;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnEstado.addActionListener(e -> btnAlterarEstadoFornecedorActionPerformed(e, socio));

        preencherDetalhesSocio(socio);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void preencherDetalhesSocio(Socio socio) {
        lblDetalhes.setText("Detalhes do Sócio " + socio.getId());
        lblId.setText(String.valueOf(socio.getId()));
        if (socio.getEstado()) {
            lblEstado.setText("Ativo");
            btnEstado.setText("Alterar Estado - Inativar");
        } else {
            lblEstado.setText("Inativo");
            btnEstado.setText("Alterar Estado - Ativar");
        }
        txtNome.setText(socio.getNome());
        txtNif.setText(String.valueOf(socio.getNIF()));
        txtCartaoCidadao.setText(String.valueOf(socio.getCartaoCidadao()));
        txtMorada.setText(socio.getMorada());
        txtTelemovel.setText(String.valueOf(socio.getTelemovel()));
        txtEmail.setText(socio.getEmail());
        cmbMetodoComunicacaoPreferido.setModel(new DefaultComboBoxModel(MetodoComunicacaoPreferido.values()));
        if (socio.getMetodoComunicacaoPreferido() == MetodoComunicacaoPreferido.EMAIL) {
            cmbMetodoComunicacaoPreferido.setSelectedIndex(0);
        } else if (socio.getMetodoComunicacaoPreferido() == MetodoComunicacaoPreferido.SMS) {
            cmbMetodoComunicacaoPreferido.setSelectedIndex(1);
        }
        lblDataCriacao.setText(socio.getDataCriacao().toString());
        //se a data depagamento da proxima anuidade for menor ou igual à data de criacao
        if (socio.getDataProximoPagamentoAnuidade().isBefore(socio.getDataCriacao())) {
            lblDataPagamentoProximaAnuidade.setText("Deve pagar a 1.ª anuidade");
        } else {
            lblDataPagamentoProximaAnuidade.setText(socio.getDataProximoPagamentoAnuidade().toString());
        }
        lblMultado.setText(socio.isMultado() ? "Sim" : "Não");
        lblAnuidadePaga.setText(socio.isAnuidadePaga() ? "Sim" : "Não");
    }

    private boolean validarDadosSocio() {
        if (txtNome.getText().trim().isEmpty() &&
                txtNif.getText().trim().isEmpty() &&
                txtCartaoCidadao.getText().trim().isEmpty() &&
                txtMorada.getText().trim().isEmpty() &&
                txtTelemovel.getText().trim().isEmpty()) {
            mostrarErro(EcraAdicionarSocio.ERRO_1);
            return false;
        } else if (txtNome.getText().trim().isEmpty()) {
            mostrarErro(EcraAdicionarSocio.ERRO_2);
            return false;
        } else if (txtNif.getText().trim().isEmpty()) {
            mostrarErro(EcraAdicionarSocio.ERRO_3);
            return false;
        } else if (txtCartaoCidadao.getText().trim().isEmpty()) {
            mostrarErro(EcraAdicionarSocio.ERRO_4);
            return false;
        } else if (txtMorada.getText().trim().isEmpty()) {
            mostrarErro(EcraAdicionarSocio.ERRO_5);
            return false;
        } else if (txtTelemovel.getText().trim().isEmpty()) {
            mostrarErro(EcraAdicionarSocio.ERRO_6);
            return false;
        } else if (!Socio.validarNif(txtNif.getText())) {
            mostrarErro(EcraAdicionarSocio.ERRO_7);
            return false;
        } else if (!DadosAplicacao.INSTANCIA.isNifUnico(Integer.parseInt(txtNif.getText()))) {
            mostrarErro(EcraAdicionarSocio.ERRO_8);
            return false;
        } else if (!Socio.validarCartaoCidadao(txtCartaoCidadao.getText())) {
            mostrarErro(EcraAdicionarSocio.ERRO_9);
            return false;
        } else if (!DadosAplicacao.INSTANCIA.isCartaoCidadaoUnico(Integer.parseInt(txtCartaoCidadao.getText()))) {
            mostrarErro(EcraAdicionarSocio.ERRO_10);
            return false;
        } else if (!Socio.validarTelemovel(txtTelemovel.getText())) {
            mostrarErro(EcraAdicionarSocio.ERRO_11);
            return false;
        }
        return true;

    }

    private void atualizardadosSocio(Socio socio){
        socio.setNome(txtNome.getText());
        socio.setNIF(Integer.parseInt(txtNif.getText()));
        socio.setCartaoCidadao(Integer.parseInt(txtCartaoCidadao.getText()));
        socio.setMorada(txtMorada.getText());
        socio.setTelemovel(Integer.parseInt(txtTelemovel.getText()));
        socio.setEmail(txtEmail.getText());
        socio.setMetodoComunicacaoPreferido((MetodoComunicacaoPreferido) cmbMetodoComunicacaoPreferido.getSelectedItem());
    }

    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void btnSairActionPerformed(ActionEvent event) {
        dispose();
    }


    private void btnAlterarEstadoFornecedorActionPerformed(ActionEvent event, Socio socio) {
        if (validarDadosSocio()){
            atualizardadosSocio(socio);
            if (socio.getEstado()) {
                socio.setEstado(false);
                lblEstado.setText("Inativo");
                btnEstado.setText("Alterar Estado - Ativar");
            } else {
                socio.setEstado(true);
                lblEstado.setText("Ativo");
                btnEstado.setText("Alterar Estado - Inativar");
            }

            painelSocio.preencherDetalhesSocio();
        }
    }
}
