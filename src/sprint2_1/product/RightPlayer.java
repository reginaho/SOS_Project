package sprint2_1.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPlayer extends JPanel {

    JLabel playerLabel;
    JRadioButton r_button1;
    JRadioButton r_button2;
    JTextField textField;
    private JRadioButton r_button3;
    private JRadioButton r_button4;
    SOSGame sosGame;

    public RightPlayer(SOSGame sosGame){
        this.sosGame = sosGame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        playerLabel= new JLabel("Blue Player");
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setBackground(Color.BLUE);
        playerLabel.setOpaque(true);

        r_button1 = new JRadioButton("S");
        r_button2 = new JRadioButton("O");
        r_button3 = new JRadioButton("Human");
        r_button4 = new JRadioButton("Computer");

        r_button1.addActionListener(new InputListener1());
        r_button2.addActionListener(new InputListener2());

        textField = new JTextField();
//        textField.addActionListener(new InputListener());

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

//        add(textField);

        r_button1.doClick(); //set default Radio button
    }
//    public void
private class InputListener1 implements ActionListener {
    private InputListener1() {
    }
    public void actionPerformed(ActionEvent e){
//        if (sosGame.getTurn() % 2 == 0){
//            sosGame.setCurrentMoveType(SOSGame.Cell.S);
//            System.out.println("j");
//        }
        System.out.println("j");
        sosGame.updateRightPlayer(SOSGame.Cell.S);
    }
}
    private class InputListener2 implements ActionListener {
        private InputListener2() {
        }
        public void actionPerformed(ActionEvent e) {
//            if (sosGame.getTurn() % 2 == 0){
//                sosGame.setCurrentMoveType(SOSGame.Cell.O);
//                System.out.println("k");
//            }
            System.out.println("o");
            sosGame.updateRightPlayer(SOSGame.Cell.O);
            //Maybe I should have a seperate move state for both p1 and p2
        }
    }
}
