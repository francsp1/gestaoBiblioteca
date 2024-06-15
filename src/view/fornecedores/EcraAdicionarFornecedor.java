package view.fornecedores;

import model.DadosAplicacao;
import model.Fornecedor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraAdicionarFornecedor extends JFrame {

    private static final String ERRO_1 = "Deve inserir os dados do fornecedor antes de adicionar um fornecedor.";
    private static final String ERRO_2 = "Deve inserir o nome do fornecedor antes de adicionar o mesmo.";
    private static final String ERRO_3 = "Deve inserir a distribuidora antes de adicionar o mesmo.";
    private static final String ERRO_4 = "Deve inserir o contacto do fornecedor antes de adicionar o mesmo.";

    private final EcraFornecedores ecraPai;
    private JPanel painelEcraAdicionarFornecedore;
    private JButton btnAdicionarFornecedor;
    private JButton btnSair;
    private JLabel lblAdicionarFornecedor;
    private JTextField txtNome;
    private JTextField txtDistribuidora;
    private JTextField txtContacto;
    private JLabel lblNome;
    private JLabel lblDistribuidora;
    private JLabel lblContacto;

    public EcraAdicionarFornecedor(EcraFornecedores ecraPai) {
        super("Adicionar Fornecedor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraAdicionarFornecedore);
        pack();

        this.ecraPai = ecraPai;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarFornecedor.addActionListener(this::btnBtnAdicionarFornecedorActionPerformed);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean validarDadosFornecedor() {
        if (txtNome.getText().trim().isEmpty() &&
                txtDistribuidora.getText().trim().isEmpty() &&
                txtContacto.getText().trim().isEmpty()) {
            mostrarErro(ERRO_1);
            return false;
        } else if (txtNome.getText().trim().isEmpty()) {
            mostrarErro(ERRO_2);
            return false;
        } else if (txtDistribuidora.getText().trim().isEmpty()) {
            mostrarErro(ERRO_3);
            return false;
        } else if (txtContacto.getText().trim().isEmpty()) {
            mostrarErro(ERRO_4);
            return false;
        }
        return true;
    }

    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);

    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {

    }

    private void btnBtnAdicionarFornecedorActionPerformed(ActionEvent actionEvent) {
        if (validarDadosFornecedor()) {
            DadosAplicacao.INSTANCIA.adicionarFornecedor(new Fornecedor(txtNome.getText(), txtDistribuidora.getText(), txtContacto.getText()));

            dispose();

            ecraPai.preencherFornecedores();
        }
    }


}
