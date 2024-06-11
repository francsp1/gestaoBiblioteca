package view.fornecedores;

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

        PainelFornecedor painel1 = new PainelFornecedor();
        PainelFornecedor painel2 = new PainelFornecedor();
        PainelFornecedor painel3 = new PainelFornecedor();
        PainelFornecedor painel4 = new PainelFornecedor();
        PainelFornecedor painel5 = new PainelFornecedor();
        PainelFornecedor painel6 = new PainelFornecedor();
        PainelFornecedor painel7 = new PainelFornecedor();
        PainelFornecedor painel8 = new PainelFornecedor();

        container.add(painel1);
        container.add(painel2);
        container.add(painel3);
        container.add(painel4);
        container.add(painel5);
        container.add(painel6);
        container.add(painel7);
        container.add(painel8);

        container.setPreferredSize(new Dimension(700, 1000)); // Set your preferred width and height

        scrollPaneFornecedores.setViewportView(container);

        container.revalidate();
        container.repaint();
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        parentFrame.setVisible(true);
    }
}
