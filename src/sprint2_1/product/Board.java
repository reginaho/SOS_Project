package sprint2_1.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
//    public static final int CELL_SIZE = 100;
    private int gridWidth = 4;
    private int gridWidthHalf = gridWidth / 2;

//    public static final int CELL_PADDING = CELL_SIZE / 6;
//    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
//    private int  SYMBOL_STROKE_WIDTH = 8;

    private int boardSize = 200;
    private int cellNum = 6;

    private int cellSize = boardSize / cellNum;
//    private int cellNum = 6;
    private int cellPadding = cellSize / 6;
    private SOSGame sosGame;
    private BottomPanel bottomPanel;
//    private int SYMBOL_SIZE = cellSize - cellPadding * 2;
    public Board(SOSGame sosGame, BottomPanel bottomPanel){
        this.sosGame = sosGame;
//        setBackground(Color.PINK);
        setPreferredSize(new Dimension(boardSize, boardSize));
        Border blackline = BorderFactory.createLineBorder(Color.BLACK, 4);
        setBorder(blackline);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//                if (game.getGameState() == GameState.PLAYING) {
                    int rowSelected = e.getY() / cellSize;
                    int colSelected = e.getX() / cellSize;
                    sosGame.makeMove(rowSelected,colSelected);
                    bottomPanel.updateTurnLabel();
                    repaint();
//                    game.makeMove(rowSelected, colSelected);
//                } else {
//                    game.resetGame();
//                }
//                repaint();
                System.out.println(rowSelected + " " + colSelected);
            }
        });
    }

    public void changeSize(int sizeInput){
        cellNum = sizeInput;
        cellSize = boardSize / cellNum;
        int newSize = cellSize * cellNum;
        setPreferredSize(new Dimension(newSize, newSize));
        sosGame.initGame(cellNum, cellNum);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.PINK);
//        setBackground(new Color(70,77,44));
        drawGridLines(g);
        drawMoves(g);
    }

    private void drawGridLines(Graphics g){
        g.setColor(Color.BLACK);
        for (int row = 1; row < cellNum; row++) {
            g.fillRoundRect(0, cellSize * row - gridWidthHalf,
                    boardSize -1, gridWidth, gridWidth, gridWidth);
        }
        for (int col = 1; col < cellNum; col++) {
            g.fillRoundRect(cellSize * col - gridWidthHalf, 0,
                    gridWidth, boardSize -1, gridWidth, gridWidth);
        }
    }
    private void drawMoves(Graphics g){
        Font font = new Font("SansSerif",Font.BOLD, (int) (0.8 * cellSize));
        FontMetrics metrics = g.getFontMetrics(font);
        g.setFont(font);
        for (int row = 0; row < sosGame.getTotalRows(); ++row) {
            for (int col = 0; col < sosGame.getTotalColumns(); ++col) {
                if (sosGame.getCell(row, col) == SOSGame.Cell.O) {
                    int x = col * cellSize + (cellSize - metrics.stringWidth("O")) / 2;
                    int y = row * cellSize + ((cellSize - metrics.getHeight()) / 2) + metrics.getAscent();
                    g.drawString("O", x, y);
                }
                else if (sosGame.getCell(row, col) == SOSGame.Cell.S) {
                    int x = col * cellSize + (cellSize - metrics.stringWidth("S")) / 2;
                    int y = row * cellSize + ((cellSize - metrics.getHeight()) / 2) + metrics.getAscent();
                    g.drawString("S", x, y);
                }
            }
        }
    }

}
