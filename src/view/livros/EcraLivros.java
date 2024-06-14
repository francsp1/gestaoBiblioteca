package view.livros;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraLivros extends JFrame {

    private final JFrame parentFrame;
    private JButton btnSair;
    private JPanel painelEcraLivros;


    public EcraLivros(JFrame parent) {
        super("Livros");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraLivros);
        pack();

        this.parentFrame = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);

        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        parentFrame.setVisible(true);
    }
}
