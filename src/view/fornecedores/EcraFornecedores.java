package view.fornecedores;

import model.DadosAplicacao;
import model.Fornecedor;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraFornecedores extends JFrame {

    private JFrame parentFrame;
    private JPanel painelEcraFornecedores;
    private JButton btnAdicionarFornecedor;
    private JButton btnSair;
    private JScrollPane scrollPaneFornecedores;

    public EcraFornecedores(String title, JFrame parent) {
        super(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraFornecedores);
        pack();

        this.parentFrame = parent;

        preencherFornecedores();

        btnSair.addActionListener(this::btnSairActionPerformed);

        this.setVisible(true);
    }

    private void preencherFornecedores() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        for (Fornecedor fornecedor : DadosAplicacao.INSTANCIA.getFornecedores()) {
            container.add(new PainelFornecedor(fornecedor));
        }


        container.setPreferredSize(new Dimension(700, 1000));

        scrollPaneFornecedores.setViewportView(container);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        parentFrame.setVisible(true);
    }
}
