package sprint2_1.product;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    final int LENGTH_FRAME = 500;
    final int WIDTH_FRAME = 500;
    private Board board;
    private LeftPlayer leftPlayer;
    private RightPlayer rightPlayer;
    private TopPanel topPanel;
    private BottomPanel bottomPanel;
    private SOSGame sosGame;
    public GUI(){
        setContentPane();
        setSize(LENGTH_FRAME,WIDTH_FRAME);
        setLocationRelativeTo((Component)null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SOS Game");
        setVisible(true);
    }

    private void setContentPane(){
        GridBagConstraints gbc = new GridBagConstraints();

        sosGame = new SOSGame();
        bottomPanel = new BottomPanel(this, sosGame);
        board = new Board(sosGame, bottomPanel);
        leftPlayer = new LeftPlayer(sosGame);
        rightPlayer = new RightPlayer(sosGame);
        topPanel= new TopPanel(sosGame);

        setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(topPanel, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = -1;
        gbc.weightx = .1;
        add(leftPlayer, gbc);

        gbc.weightx = .8;
        gbc.gridx = 1;
        add(board, gbc);

        gbc.weightx = .1;
        gbc.gridx = 2;
        add(rightPlayer, gbc);

        gbc.gridwidth = 3;
        gbc.gridy = -2;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(bottomPanel, gbc);
    }

    public void setBoardSize(){
        //check
        board.changeSize(topPanel.getBoardSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
