package view.encomenda;

import model.DadosAplicacao;
import model.Encomenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraEncomendas extends JFrame {
    private final JFrame parentFrame;
    private JButton criarEncomendaButton;
    private JButton sairButton;
    private JPanel painelEcraEncomendas;
    private JLabel lblEncomendas;
    private JScrollPane ScrollPaneEncomendas;


    public EcraEncomendas(JFrame parentFrame) {
        super("Encomendas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraEncomendas);
        pack();

        this.parentFrame = parentFrame;

        sairButton.addActionListener(this::sairButtonActionPerformed);
        criarEncomendaButton.addActionListener(this::criarEncomendaButtonActionPerformed);

        preencherEncomendas();

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void preencherEncomendas() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Encomenda encomenda : DadosAplicacao.INSTANCIA.getEncomendas()) {
            container.add(new PainelEncomenda(this, encomenda), gbc);
        }

        ScrollPaneEncomendas.setViewportView(container);
    }

    private void sairButtonActionPerformed(ActionEvent actionEvent) {
        dispose();
        parentFrame.setVisible(true);
    }

    private void criarEncomendaButtonActionPerformed(ActionEvent actionEvent) {
        new EcraAdicionarEncomenda(this);
    }
}
