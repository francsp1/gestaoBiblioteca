package view.fornecedores;

import model.Fornecedor;
import view.common.Painel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelFornecedor extends Painel {
    private final Fornecedor fornecedor;
    private final JLabel lblId;
    private final JLabel lblNome;
    private final JLabel lblDistribuidora;
    private final JLabel lblContacto;
    private final JLabel lblEstado;
    private final JButton btnDetalhes;
    


    public PainelFornecedor(EcraFornecedores ecraPai, Fornecedor fornecedor){
        super(ecraPai);

        this.fornecedor = fornecedor;

        lblId = new JLabel();
        lblNome = new JLabel();
        lblDistribuidora = new JLabel();
        lblContacto = new JLabel();
        lblEstado = new JLabel();
        btnDetalhes = new JButton();

        preencherDetalhesFornecedor();

        desenharPainel();

        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, fornecedor));

    }

    private void preencherDetalhesFornecedor() {
        lblId.setText("ID: " + fornecedor.getId());
        lblNome.setText("Nome: " + fornecedor.getNome());
        lblDistribuidora.setText("Distribuidora: " + fornecedor.getDistribuidora());
        lblContacto.setText("Contacto: "+ fornecedor.getContacto());
        StringBuilder estado = new StringBuilder();
        estado.append("Estado: ");
        if (fornecedor.getEstado()) {
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
        setLayout(new GridLayout(6, 1)); // Adjust layout as needed
        add(lblId);
        add(lblNome);
        add(lblDistribuidora);
        add(lblContacto);
        add(lblEstado);
        add(btnDetalhes);
    }

    private void btnDetalhesActionPerformed(ActionEvent actionEvent, Fornecedor fornecedor) {
        EcraFornecedores ecraPai = (EcraFornecedores) this.ecraPai;
        new EcraDetalhesFornecedor(ecraPai, fornecedor);
    }
}
