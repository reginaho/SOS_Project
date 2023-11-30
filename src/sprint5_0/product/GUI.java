package sprint5_0.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

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

        sosGame = new SimpleComputerGame();
        bottomPanel = new BottomPanel(this, sosGame);
        board = new Board(sosGame, bottomPanel, this);
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
        board.changeSize(topPanel.getBoardSize());
    }
    //board object changes here
    public void resetBoard(){
        if(sosGame.getGameType() == SOSGame.GameType.SIMPLE_GAME) {
            sosGame = new SimpleComputerGame(sosGame.getLeftPlayer(), sosGame.getRightPlayer(), sosGame.getLeftPlayerType(), sosGame.getRightPlayerType());
        }
        else{
            sosGame = new GeneralComputerGame(sosGame.getLeftPlayer(), sosGame.getRightPlayer(),sosGame.getLeftPlayerType(), sosGame.getRightPlayerType());
        }

        setInstance();
        sosGame.initGame(sosGame.getTotalRows(), sosGame.getTotalRows());
        setBoardSize();
        ComputerMove();
    }
    public void ComputerMove(){
        if(sosGame.getGameState() == SOSGame.GameState.PLAYING) {
            if ((sosGame.getTurn() % 2 == 1) && sosGame.getLeftPlayerType() == SOSGame.PlayerType.COMPUTER_PLAYER) {
                sosGame.makeMove();
                ComputerMove();
            } else if ((sosGame.getTurn() % 2 == 0) && sosGame.getRightPlayerType() == SOSGame.PlayerType.COMPUTER_PLAYER) {
                sosGame.makeMove();
                ComputerMove();
            }
        }
        else{
//            bottomPanel.updateTurnLabel();
        }
    }
    public void setInstance(){
        bottomPanel.setInstance(sosGame);
        board.setInstance(sosGame);
        leftPlayer.setInstance(sosGame);
        rightPlayer.setInstance(sosGame);
        topPanel.setInstance(sosGame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
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
            r_button3.addActionListener(new InputListener3());
            r_button4.addActionListener(new InputListener4());

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
        private class InputListener3 implements ActionListener {
            private InputListener3() {
            }
            public void actionPerformed(ActionEvent e){
                sosGame.setLeftPlayerType(SOSGame.PlayerType.HUMAN_PLAYER);
            }
        }
        private class InputListener4 implements ActionListener {
            private InputListener4() {
            }
            public void actionPerformed(ActionEvent e) {
                sosGame.setLeftPlayerType(SOSGame.PlayerType.COMPUTER_PLAYER);
            }
        }
        public void setInstance(SOSGame sosGame){
            this.sosGame = sosGame;
        }
    }

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
            r_button3.addActionListener(new InputListener3());
            r_button4.addActionListener(new InputListener4());

            textField = new JTextField();

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
                sosGame.updateRightPlayer(SOSGame.Cell.S);
            }
        }
        private class InputListener2 implements ActionListener {
            private InputListener2() {
            }
            public void actionPerformed(ActionEvent e) {
                sosGame.updateRightPlayer(SOSGame.Cell.O);
            }
        }
        private class InputListener3 implements ActionListener {
            private InputListener3() {
            }
            public void actionPerformed(ActionEvent e){
                sosGame.setRightPlayerType(SOSGame.PlayerType.HUMAN_PLAYER);
            }
        }
        private class InputListener4 implements ActionListener {
            private InputListener4() {
            }
            public void actionPerformed(ActionEvent e) {
                sosGame.setRightPlayerType(SOSGame.PlayerType.COMPUTER_PLAYER);
            }
        }
        public void setInstance(SOSGame sosGame){
            this.sosGame = sosGame;
        }
    }
    public class Board extends JPanel {
        private int gridWidth = 4;
        private int gridWidthHalf = gridWidth / 2;
        private int boardSize = 200;
        private int cellNum = 6;

        private int cellPixelSize = boardSize / cellNum;
        private SOSGame sosGame;
        private Vector<SOSGame.Combination> combinations;
        private BottomPanel bottomPanel;
        private GUI gui;
        public Board(SOSGame sosGame, BottomPanel bottomPanel, GUI gui){
            this.sosGame = sosGame;
            this.bottomPanel = bottomPanel;
            this.gui = gui;
            setPreferredSize(new Dimension(boardSize, boardSize));
            Border blackline = BorderFactory.createLineBorder(Color.BLACK, 4);
            setBorder(blackline);

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    mouseAction(e.getY(), e.getX());
                }
            });
        }

        public void changeSize(int sizeInput){
            Boolean sizeVarification = sosGame.initGame(sizeInput, sizeInput);
            if (sizeVarification) {
                cellNum = sizeInput;
                cellPixelSize = boardSize / cellNum;
                int newSize = cellPixelSize * cellNum;
                setPreferredSize(new Dimension(newSize, newSize));
                repaint();
            }
            else {
                JOptionPane.showMessageDialog(null, "Game board size must be in range " + SOSGame.BOARD_SIZE_MIN + " to " + SOSGame.BOARD_SIZE_MAX);
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.PINK);
            drawGridLines(g);
            drawMoves(g);
        }

        private void drawGridLines(Graphics g){
            g.setColor(Color.BLACK);
            for (int row = 1; row < cellNum; row++) {
                g.fillRoundRect(0, cellPixelSize * row - gridWidthHalf,
                        boardSize -1, gridWidth, gridWidth, gridWidth);
            }
            for (int col = 1; col < cellNum; col++) {
                g.fillRoundRect(cellPixelSize * col - gridWidthHalf, 0,
                        gridWidth, boardSize -1, gridWidth, gridWidth);
            }
        }
        private void drawMoves(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            Font font = new Font("SansSerif",Font.BOLD, (int) (0.8 * cellPixelSize));
            FontMetrics metrics = g.getFontMetrics(font);
            g.setFont(font);

            for (int row = 0; row < sosGame.getTotalRows(); ++row) {
                for (int col = 0; col < sosGame.getTotalColumns(); ++col) {
                    if (sosGame.getCell(row, col) == SOSGame.Cell.O) {
                        int xCenterLocation = col * cellPixelSize + (cellPixelSize - metrics.stringWidth("O")) / 2;
                        int yCenterLocation = row * cellPixelSize + ((cellPixelSize - metrics.getHeight()) / 2) + metrics.getAscent();
                        g.drawString("O", xCenterLocation, yCenterLocation);
                    }
                    else if (sosGame.getCell(row, col) == SOSGame.Cell.S) {
                        int x = col * cellPixelSize + (cellPixelSize - metrics.stringWidth("S")) / 2;
                        int y = row * cellPixelSize + ((cellPixelSize - metrics.getHeight()) / 2) + metrics.getAscent();
                        g.drawString("S", x, y);
                    }
                }
            }
            combinations = sosGame.getCombinations();
            for(int i = 0; i < combinations.size(); i++){
                if(combinations.get(i).getPlayerTurn()){
                    g2d.setColor(Color.BLUE);
                }
                else{
                    g2d.setColor(Color.RED);
                }
                g2d.drawLine(combinations.get(i).getCol1() * cellPixelSize + (cellPixelSize / 2), combinations.get(i).getRow1() * cellPixelSize + (cellPixelSize / 2), combinations.get(i).getCol2() * cellPixelSize + (cellPixelSize / 2),combinations.get(i).getRow2() * cellPixelSize + (cellPixelSize / 2));
            }
        }
        public void mouseAction(int y, int x){
            int rowSelected = y / cellPixelSize;
            int colSelected = x / cellPixelSize;
            sosGame.makeMove(rowSelected,colSelected);
            if (sosGame.getTurn() % 2 == 0 && sosGame.getRightPlayerType() == SOSGame.PlayerType.COMPUTER_PLAYER) {
                sosGame.makeMove();
            } else if (sosGame.getTurn() % 2 == 1 && sosGame.getLeftPlayerType() == SOSGame.PlayerType.COMPUTER_PLAYER) {
                sosGame.makeMove();
            }
            gui.ComputerMove();
            bottomPanel.updateTurnLabel();
            repaint();
        }
        public void setInstance(SOSGame sosGame){
            this.sosGame = sosGame;
            bottomPanel.setInstance(sosGame);
        }
    }
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
        public void setInstance(SOSGame sosGame){
            this.sosGame = sosGame;
        }
    }

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

            setLayout(new GridBagLayout());
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            add(new Panel(), gbc);

            gbc.gridx = 1;
            gbc.weightx = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            add(turnLabel, gbc);

            gbc.gridx = 2;
            gbc.weightx = 1;
            gbc.anchor= GridBagConstraints.LINE_END;
            add(newGameButton, gbc);
        }

        public void updateTurnLabel(){
            if (sosGame.getGameState() == SOSGame.GameState.BLUE_WON) {
                turnLabel.setText("Blue player won - press \"Start\" to play again");
                JOptionPane.showMessageDialog(null, "Blue player won - press \"Start\" to play again");
            }
            else if (sosGame.getGameState() == SOSGame.GameState.RED_WON) {
                turnLabel.setText("Red player won - press \"Start\" to play again");
                JOptionPane.showMessageDialog(null, "Red player won - press \"Start\" to play again");
            }
            else if (sosGame.getGameState() == SOSGame.GameState.DRAW) {
                turnLabel.setText("Draw - press \"Start\" to play again");
                JOptionPane.showMessageDialog(null, "Draw - press \"Start\" to play again");
            }
            else if (sosGame.getTurn() % 2 == 0) {
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
                gui.resetBoard();
                updateTurnLabel();
            }
        }
        public void setInstance(SOSGame sosGame){
            this.sosGame = sosGame;
        }
    }


}
