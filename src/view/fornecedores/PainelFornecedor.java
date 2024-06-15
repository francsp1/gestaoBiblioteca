package view.fornecedores;

import model.Fornecedor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PainelFornecedor extends JPanel{
    private final EcraFornecedores ecraPai;

    public PainelFornecedor(EcraFornecedores ecraPai, Fornecedor fornecedor){
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackBorder);

        this.ecraPai = ecraPai;

        JLabel lblId = new JLabel("ID: " + fornecedor.getId());
        JLabel lblNome = new JLabel("Nome: " + fornecedor.getNome());
        JLabel lblDistribuidora = new JLabel("Distribuidora: " + fornecedor.getDistribuidora());
        JLabel lblContacto = new JLabel("Contacto: "+ fornecedor.getContacto());

        StringBuilder estado = new StringBuilder();
        estado.append("Estado: ");
        if (fornecedor.isAtivo()) {
            estado.append("Ativo");
        }else {
            estado.append("Inativo");
        }
        JLabel lblEstado = new JLabel(estado.toString());

        JButton btnDetalhes = new JButton("Detalhes");
        btnDetalhes.addActionListener(e -> btnDetalhesActionPerformed(e, fornecedor));


        setLayout(new GridLayout(6, 1)); // Adjust layout as needed
        add(lblId);
        add(lblNome);
        add(lblDistribuidora);
        add(lblContacto);
        add(lblEstado);
        add(btnDetalhes);

    }

    private void btnDetalhesActionPerformed(ActionEvent actionEvent, Fornecedor fornecedor) {
        EcraDetalhesFornecedor ecraDetalhesFornecedor = new EcraDetalhesFornecedor(ecraPai, fornecedor);
    }
}
