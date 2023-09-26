package sprint2_0.product;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    final int LENGTH_FRAME = 500;
    final int WIDTH_FRAME = 500;
    private Board board;
    private LeftPlayer leftPlayer;
    private RightPlayer rightPlayer;
    private JPanel topPanel;
    private JPanel bottomPanel;
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

        board = new Board();
        leftPlayer = new LeftPlayer();
        rightPlayer = new RightPlayer();
        topPanel= new JPanel();
        bottomPanel = new JPanel();


        setLayout(new GridBagLayout());

//        add(leftPlayer, BorderLayout.LINE_START);
//        add(board, BorderLayout.CENTER);
//        add(rightPlayer, BorderLayout.LINE_END);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        add(topPanel, gbc);

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
        add(bottomPanel, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
