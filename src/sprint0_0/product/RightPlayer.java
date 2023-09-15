package sprint0_0.product;

import javax.swing.*;
import java.awt.*;

public class RightPlayer extends JPanel {

    JLabel playerLabel;
    JRadioButton r_button1;
    JRadioButton r_button2;
    JCheckBox checkBox;
    JRadioButton r_button3;
    JRadioButton r_button4;

    public RightPlayer(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        playerLabel= new JLabel("Blue Player");
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setBackground(Color.BLUE);
        playerLabel.setOpaque(true);

        r_button1 = new JRadioButton("S");
        r_button2 = new JRadioButton("O");
        r_button3 = new JRadioButton("Human");
        r_button4 = new JRadioButton("Computer");

        checkBox = new JCheckBox("Check Box");

        ButtonGroup group = new ButtonGroup();
        group.add(r_button1);
        group.add(r_button2);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(r_button3);
        group2.add(r_button4);

        add(playerLabel);
        add(r_button1);
        add(r_button2);
        add(r_button3);
        add(r_button4);

        add(checkBox);

        r_button1.doClick(); //set default Radio button
    }
}
