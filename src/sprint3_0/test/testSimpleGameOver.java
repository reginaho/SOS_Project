package sprint3_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint3_0.product.SOSGame;
import sprint3_0.product.SimpleGame;

import static org.junit.Assert.assertEquals;

public class testSimpleGameOver {
    private SOSGame sosGame;

    @Before
    public void setUp() throws Exception {
        int userInput = 3;

        sosGame = new SimpleGame();
        sosGame.initGame(userInput, userInput);
    }

    //acceptance criteria 5.1
    @Test
    public void testSimpleGameWin() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        sosGame.makeMove(2,0);
        sosGame.makeMove(2,1);
        sosGame.makeMove(2,2);

        assertEquals(SOSGame.GameState.RED_WON, sosGame.getGameState());
    }

    //acceptance criteria 5.2
    @Test
    public void testSimpleGameDraw() {
        sosGame.updateLeftPlayer(SOSGame.Cell.O);
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        for(int row = 0; row < sosGame.getTotalRows(); row++) {
            for (int col = 0; col < sosGame.getTotalColumns(); col++) {
                sosGame.makeMove(row, col);
            }
        }
        assertEquals(SOSGame.GameState.DRAW, sosGame.getGameState());
    }
}