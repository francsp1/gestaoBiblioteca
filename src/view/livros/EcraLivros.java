package view.livros;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraLivros extends JFrame {

    private JFrame parentFrame;
    private JButton btnSair;
    private JPanel painelEcraLivros;


    public EcraLivros(String title, JFrame parent) {
        super(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(painelEcraLivros);
        pack();

        this.parentFrame = parent;

        btnSair.addActionListener(this::btnSairActionPerformed);

        this.setVisible(true);

    }

    private void btnSairActionPerformed(ActionEvent actionEvent) {
        this.dispose();
        parentFrame.setVisible(true);
    }
}
