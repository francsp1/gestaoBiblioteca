package view.fornecedores;

import model.Fornecedor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PainelFornecedor extends JPanel{
    private JPanel painelFornecedor;
    private JLabel lblDistribuidora;
    private JLabel lblContacto;
    private JLabel lblNome;
    private JLabel lblId;
    private JButton btnDetalhes;

    public PainelFornecedor(Fornecedor fornecedor){
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(blackBorder);


        // Initialize your components here
        lblId = new JLabel("ID: " + fornecedor.getId());
        lblNome = new JLabel("Nome: " + fornecedor.getNome());
        lblDistribuidora = new JLabel("Distribuidora: " + fornecedor.getDistribuidora());
        lblContacto = new JLabel("Contacto: "+ fornecedor.getContacto());

        btnDetalhes = new JButton("Detalhes");


        setLayout(new GridLayout(5, 1)); // Adjust layout as needed
        add(lblId);
        add(lblNome);
        add(lblDistribuidora);
        add(lblContacto);
        add(btnDetalhes);

    }
}
