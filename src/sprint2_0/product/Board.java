package sprint2_0.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board extends JPanel {
//    public static final int CELL_SIZE = 100;
    public static final int GRID_WIDTH = 8;
    public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;

//    public static final int CELL_PADDING = CELL_SIZE / 6;
//    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public static final int SYMBOL_STROKE_WIDTH = 8;

    public static final int Board_Size = 200;
    public static final int CELL_SIZE = Board_Size / 3;
    public static final int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public Board(){
//        setBackground(Color.PINK);
        setPreferredSize(new Dimension(Board_Size,Board_Size));
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackline);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.PINK);
        drawGridLines(g);
    }

    private void drawGridLines(Graphics g){
        g.setColor(Color.BLACK);
        for (int row = 1; row < 3; row++) {
            g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF,
                    Board_Size-1, GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
        }
        for (int col = 1; col < 3; col++) {
            g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0,
                    GRID_WIDTH, Board_Size-1, GRID_WIDTH, GRID_WIDTH);
        }
    }
}
