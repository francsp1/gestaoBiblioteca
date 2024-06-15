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
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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


    public void preencherFornecedores() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        for (Fornecedor fornecedor : DadosAplicacao.INSTANCIA.getFornecedores()) {
            container.add(new PainelFornecedor(this, fornecedor));
        }


        container.setPreferredSize(new Dimension(700, 1000));

        scrollPaneFornecedores.setViewportView(container);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        dispose();
        parentFrame.setVisible(true);
    }

    private void btnAdicionarFornecedorActionPerformed(ActionEvent actionEvent) {
        EcraAdicionarFornecedor ecraAdicionarFornecedor = new EcraAdicionarFornecedor(this);
    }


}
