package view.encomenda;

import model.Encomenda;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraDetalhesEncomenda extends JFrame{

    private static final String ERRO_1 = "Inserir todos os dados da encomenda";
    private static final String ERRO_2 = "Inserir o Livro.";
    private static final String ERRO_3 = "Inserir o Fornecedor";
    private static final String ERRO_4 = "Inserir o ISBN";
    private static final String ERRO_5 = "Inserir as Unidades";

    private final EcraEncomendas ecraPai;
    private final PainelEncomenda painelEncomenda;
    private JPanel painelEcraDetalhesEncomenda;
    private JTextField textFieldLivro;
    private JTextField textFieldFornecedor;
    private JTextField textFieldISBN;
    private JTextField textFieldUnidades;
    private JButton estadoButton;
    private JButton confirmarAlteraçõesButton;
    private JButton sairButton;
    private JLabel lblEstado;
    private JLabel lblDetalhes;


    public EcraDetalhesEncomenda(EcraEncomendas ecraPai, PainelEncomenda painelEncomenda, Encomenda encomenda) {
        super("Detalhes do Encomenda");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraDetalhesEncomenda);
        pack();

        this.ecraPai = ecraPai;
        this.painelEncomenda = painelEncomenda;

        sairButton.addActionListener(this::sairButtonActionPerformed);
        estadoButton.addActionListener(e -> btnAlterarEstadoEncomendaActionPerformed(e, encomenda));

        preencherDetalhesEncomenda(encomenda);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    //funcoes
    private void preencherDetalhesEncomenda(Encomenda encomenda) {
        lblDetalhes.setText("Detalhes Encomenda " + encomenda.getId());
        textFieldLivro.setText(String.valueOf(encomenda.getLivro()));
        textFieldFornecedor.setText(String.valueOf(encomenda.getFornecedor()));
        textFieldISBN.setText(encomenda.getIsbn());
        textFieldUnidades.setText(String.valueOf(encomenda.getN_unidades()));
        if (encomenda.getEstado()) {
            lblEstado.setText("Ativo");
            estadoButton.setText("Alterar Estado - Inativar Livro");
        } else {
            lblEstado.setText("Inativo");
            estadoButton.setText("Alterar Estado - Ativar Livro");
        }
    }



    private boolean validarDadosEncomenda() {
        if (textFieldLivro.getText().trim().isEmpty() && textFieldFornecedor.getText().trim().isEmpty() &&
                textFieldISBN.getText().trim().isEmpty() && textFieldUnidades.getText().trim().isEmpty()) {
            mostrarErro(ERRO_1);
            return false;
        } else if (textFieldLivro.getText().trim().isEmpty()) {
            mostrarErro(ERRO_2);
            return false;
        } else if (textFieldFornecedor.getText().trim().isEmpty()) {
            mostrarErro(ERRO_3);
            return false;
        } else if (textFieldISBN.getText().trim().isEmpty()) {
            mostrarErro(ERRO_4);
            return false;
        } else if (textFieldUnidades.getText().trim().isEmpty()) {
            mostrarErro(ERRO_5);
            return false;
        }

        return true;
    }

    private void atualizarDadosEncomenda(Encomenda encomenda) {
        encomenda.setLivro(textFieldLivro.getText());
        encomenda.setFornecedor(textFieldFornecedor.getText());
        encomenda.setIsbn(textFieldISBN.getText());
        encomenda.setN_unidades(Integer.parseInt(textFieldUnidades.getText()));
    }


    private void mostrarErro(String erro) {
        JOptionPane.showMessageDialog(this, erro);
    }

    //buttons
    private void sairButtonActionPerformed(ActionEvent actionEvent) {
        dispose();
    }

    private void btnAlterarEstadoEncomendaActionPerformed(ActionEvent e, Encomenda encomenda) {
        if (validarDadosEncomenda()) {
            atualizarDadosEncomenda(encomenda);
            if (encomenda.getEstado()) { // Se o encomenda está ativa
                encomenda.setEstado(false);
                lblEstado.setText("Inativo");
                estadoButton.setText("Alterar Estado - Ativar Encomenda");
            } else { // Se o encomenda está inativa
                encomenda.setEstado(true);
                lblEstado.setText("Ativo");
                estadoButton.setText("Alterar Estado - Inativar Encomenda");
            }

            painelEncomenda.preencherDetalhesEncomenda();
        }
    }
}
