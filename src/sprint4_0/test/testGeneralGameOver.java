package sprint4_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint4_0.product.GeneralComputerGame;
import sprint4_0.product.SOSGame;

import static org.junit.Assert.assertEquals;

public class testGeneralGameOver {
    private SOSGame sosGame;

    @Before
    public void setUp() throws Exception {
        int userInput = 3;

        sosGame = new GeneralComputerGame();
        sosGame.initGame(userInput, userInput);
    }

    //acceptance criteria 7.1
    @Test
    public void testGeneralGameWin() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        for(int row = 0; row < sosGame.getTotalRows(); row++) {
            for (int col = 0; col < sosGame.getTotalColumns(); col++) {
                sosGame.makeMove(row, col);
            }
        }

        assertEquals(SOSGame.GameState.RED_WON, sosGame.getGameState());
    }

    //acceptance criteria 7.2
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