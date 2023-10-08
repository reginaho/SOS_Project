package sprint2_1.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    private int gridWidth = 4;
    private int gridWidthHalf = gridWidth / 2;
    private int boardSize = 200;
    private int cellNum = 6;

    private int cellPixelSize = boardSize / cellNum;
    private SOSGame sosGame;
    private BottomPanel bottomPanel;
    public Board(SOSGame sosGame, BottomPanel bottomPanel){
        this.sosGame = sosGame;
        this.bottomPanel = bottomPanel;
        setPreferredSize(new Dimension(boardSize, boardSize));
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 4);
        setBorder(blackline);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    int rowSelected = e.getY() / cellPixelSize;
                    int colSelected = e.getX() / cellPixelSize;
                    sosGame.makeMove(rowSelected,colSelected);
                    bottomPanel.updateTurnLabel();
                    repaint();
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
    }
}
