package view.livros;

import model.DadosAplicacao;
import model.Livro;

import javax.swing.*;
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

    void preencherLivros() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        for (Livro livro : DadosAplicacao.INSTANCIA.getLivros()) {
             container.add(new PainelLivro(this, livro));
        }

        container.setPreferredSize(new java.awt.Dimension(700, 1000));

        scrollPaneLivros.setViewportView(container);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        ecraPai.setVisible(true);
    }
}
