package sprint0_0.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board extends JPanel {
    public Board(){
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(200,200));
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);

    }
}
