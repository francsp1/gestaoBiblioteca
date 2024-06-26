package view.fornecedores;

import model.DadosAplicacao;
import model.Fornecedor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcraFornecedores extends JFrame {

    private final JFrame parentFrame;
    private JPanel painelEcraFornecedores;
    private JButton btnAdicionarFornecedor;
    private JButton btnSair;
    private JScrollPane scrollPaneFornecedores;
    private JLabel lblFornecedores;

    public EcraFornecedores(JFrame parent) {
        super("Fornecedores");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraFornecedores);
        pack();

        this.parentFrame = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnAdicionarFornecedor.addActionListener(this::btnAdicionarFornecedorActionPerformed);

        preencherFornecedores();

        setLocationRelativeTo(null);
        setVisible(true);
    }


    protected void preencherFornecedores() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Fornecedor fornecedor : DadosAplicacao.INSTANCIA.getFornecedores()) {
            container.add(new PainelFornecedor(this, fornecedor), gbc);
        }

        scrollPaneFornecedores.setViewportView(container);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
        parentFrame.setVisible(true);
    }

    private void btnAdicionarFornecedorActionPerformed(ActionEvent actionEvent) {
        new EcraAdicionarFornecedor(this);
    }


}
