package sprint2_1.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPlayer extends JPanel {
    JLabel playerLabel;
    JRadioButton r_button1;
    JRadioButton r_button2;
    JCheckBox checkBox;
    JRadioButton r_button3;
    JRadioButton r_button4;
    private SOSGame sosGame;
    public LeftPlayer(SOSGame sosGame){
        this.sosGame = sosGame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        playerLabel= new JLabel("Red Player");
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setBackground(Color.RED);
        playerLabel.setOpaque(true);

        r_button1 = new JRadioButton("S");
        r_button2 = new JRadioButton("O");
        r_button3 = new JRadioButton("Human");
        r_button4 = new JRadioButton("Computer");

        r_button1.addActionListener(new InputListener1());
        r_button2.addActionListener(new InputListener2());

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

        r_button1.doClick();
    }
    private class InputListener1 implements ActionListener {
        private InputListener1() {
        }
        public void actionPerformed(ActionEvent e){
            sosGame.updateLeftPlayer(SOSGame.Cell.S);
        }
    }
    private class InputListener2 implements ActionListener {
        private InputListener2() {
        }
        public void actionPerformed(ActionEvent e) {
            sosGame.updateLeftPlayer(SOSGame.Cell.O);
        }
    }
}
