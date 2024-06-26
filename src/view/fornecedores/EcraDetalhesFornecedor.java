package view.fornecedores;

import model.Fornecedor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraDetalhesFornecedor extends JFrame {
    private final EcraFornecedores ecraPai;
    private JPanel painelEcraDetalhesFornecedor;
    private JButton btnConfirmar;
    private JButton btnSair;
    private JButton btnEstado;
    private JLabel lblDetalhes;
    private JTextField txtNome;
    private JTextField txtDistribuidora;
    private JTextField txtContacto;
    private JLabel lblNome;
    private JLabel lblDistribuidora;
    private JLabel lblContacto;
    private JLabel lblId;
    private JLabel lblIdPrefix;
    private JLabel lblEstado;
    private JLabel lblEstadoPrefix;
    private JPanel painelDetalhesFornecedor;

    public EcraDetalhesFornecedor(EcraFornecedores ecraPai, Fornecedor fornecedor) {
        super("Detalhes do Fornecedor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesFornecedor);
        pack();

        this.ecraPai = ecraPai;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnEstado.addActionListener(e -> btnAlterarEstadoFornecedorActionPerformed(e, fornecedor));

        preencherDetalhesFornecedor(fornecedor);

        setLocationRelativeTo(null);
        setVisible(true);

    }


    private void preencherDetalhesFornecedor(Fornecedor fornecedor) {
        lblDetalhes.setText("Detalhes do Fornecedor " + fornecedor.getId());

        lblId.setText(Integer.toString(fornecedor.getId()));
        txtNome.setText(fornecedor.getNome());
        txtDistribuidora.setText(fornecedor.getDistribuidora());
        txtContacto.setText(fornecedor.getContacto());

        if (fornecedor.getEstado()) {
            lblEstado.setText("Ativo");
            btnEstado.setText("Alterar Estado - Inativar Fornecedor");
        } else {
            lblEstado.setText("Inativo");
            btnEstado.setText("Alterar Estado - Ativar Fornecedor");
        }


    }


    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnAlterarEstadoFornecedorActionPerformed(ActionEvent actionEvent, Fornecedor fornecedor) {
        if (fornecedor.getEstado()) {
            fornecedor.setEstado(false);
            lblEstado.setText("Inativo");
            btnEstado.setText("Alterar Estado - Ativar Fornecedor");
        } else {
            fornecedor.setEstado(true);
            lblEstado.setText("Ativo");
            btnEstado.setText("Alterar Estado - Inativar Fornecedor");
        }

        ecraPai.preencherFornecedores();
    }
}
