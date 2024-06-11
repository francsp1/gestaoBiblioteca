package view.fornecedores;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PainelFornecedor extends JPanel{
    private JPanel painelFornecedor;
    private JLabel lblDistribuidoraPrefix;
    private JLabel lblDistribuidora;
    private JLabel lblContactoPrefix;
    private JLabel lblContacto;
    private JLabel lblNomePrefix;
    private JLabel lblNome;
    private JLabel lblIdPrefix;
    private JLabel lblId;
    private JButton btnDetalhes;

    public PainelFornecedor(){
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(blackBorder);

        
        setVisible(true);


    }
}
