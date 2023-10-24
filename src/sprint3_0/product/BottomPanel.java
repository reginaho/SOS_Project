package sprint2_1.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {
    JButton newGameButton;
    JLabel turnLabel;
    private Board board;
    GUI gui;
    SOSGame sosGame;
    public BottomPanel(GUI gui, SOSGame sosGame){
        this.board = board;
        this.sosGame = sosGame;
        GridBagConstraints gbc = new GridBagConstraints();
        this.gui = gui;
        newGameButton = new JButton("Start");
        newGameButton.addActionListener(new InputListener());
        turnLabel = new JLabel("Press Start");

//        setBackground(Color.BLUE);

        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        add(new Panel(), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(turnLabel, gbc);

        gbc.gridx = 2;
        gbc.weightx = 1;
        gbc.anchor= GridBagConstraints.LINE_END;
//        gbc.fill = GridBagConstraints.NONE;
        add(newGameButton, gbc);
    }

    public void updateTurnLabel(){
        if (sosGame.getTurn() % 2 == 0) {
            turnLabel.setText("Turn: Blue Player");
        } else if (sosGame.getTurn() % 2 == 1) {
            turnLabel.setText("Turn: Red Player");
        }
        repaint();
    }
    private class InputListener implements ActionListener {
        private InputListener() {
        }
        public void actionPerformed(ActionEvent e){
            gui.setBoardSize();
            updateTurnLabel();
        }
    }
}
