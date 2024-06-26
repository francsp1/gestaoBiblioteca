package view.livros;

import model.DadosAplicacao;
import model.Livro;
import model.Socio;
import view.socios.PainelSocio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraLivros extends JFrame {

    private final JFrame ecraPai;
    private JButton btnSair;
    private JPanel painelEcraLivros;
    private JLabel lblLivros;
    private JScrollPane scrollPaneLivros;
    private JButton button1;
    private JButton button2;


    public EcraLivros(JFrame parent) {
        super("Livros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelEcraLivros);
        pack();

        this.ecraPai = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);

        preencherLivros();

        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    protected void preencherLivros() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Livro livro : DadosAplicacao.INSTANCIA.getLivros()) {
            container.add(new PainelLivro(this, livro), gbc);
        }

        scrollPaneLivros.setViewportView(container);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        ecraPai.setVisible(true);
    }
}
