package sprint2_0.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
    private JTextField textField;
    private JPanel leftSide;
    private JPanel rightSide;
    private JRadioButton r_button1;
    private JRadioButton r_button2;
    private SOSGame sosGame;
    TopPanel(SOSGame sosGame){
        GridBagConstraints gbc = new GridBagConstraints();
        this.sosGame= sosGame;
        leftSide = new JPanel();
        rightSide = new JPanel();
        textField = new JTextField("6", 3);
        JLabel title = new JLabel("SOS");

        ButtonGroup group = new ButtonGroup();
        r_button1 = new JRadioButton("Simple Game");
        r_button2 = new JRadioButton("General Game");
        group.add(r_button1);
        group.add(r_button2);

        r_button1.addActionListener(new InputListener1());
        r_button2.addActionListener(new InputListener2());

        leftSide.add(r_button1);
        leftSide.add(r_button2);

        rightSide.add(new JLabel("Board size:"));
        rightSide.add(textField);

        setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor= GridBagConstraints.PAGE_START;
        add(leftSide, gbc);

        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.anchor= GridBagConstraints.PAGE_END;
        add(rightSide, gbc);

        r_button1.doClick();
    }
    public int getBoardSize(){
        return  Integer.parseInt(textField.getText());
    }
    private class InputListener1 implements ActionListener {
        private InputListener1() {
        }
        public void actionPerformed(ActionEvent e){
            sosGame.updateGameType(SOSGame.GameType.SIMPLE_GAME);
        }
    }
    private class InputListener2 implements ActionListener {
        private InputListener2() {
        }
        public void actionPerformed(ActionEvent e) {
            sosGame.updateGameType(SOSGame.GameType.GENERAL_GAME);
        }
    }
}
