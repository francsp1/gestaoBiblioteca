package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Painel extends JPanel {
    protected final JFrame ecraPai;

    public Painel(JFrame ecraPai) {
        this.ecraPai = ecraPai;
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackBorder);
    }

    protected void setBackGroundVerde() {
        setBackground(new Color(204, 255, 204));
    }

    protected void setBackGroundVermelho() {
        setBackground(new Color(255, 204, 204));
    }


}
