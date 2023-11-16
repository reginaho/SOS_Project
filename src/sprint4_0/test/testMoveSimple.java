package sprint4_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint3_0.product.SOSGame;
import sprint3_0.product.SimpleGame;

import static org.junit.Assert.assertEquals;

public class testMoveSimple {
    private SOSGame sosGame;

    @Before
    public void setUp() throws Exception {
        int userInput = 9;

        sosGame = new SimpleGame();
        sosGame.initGame(userInput, userInput);
    }

    //acceptance criteria 4.1
    @Test
    public void testSimpleMoveS() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.S, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 4.2
    @Test
    public void testSimpleMoveO() {
        sosGame.updateLeftPlayer(SOSGame.Cell.O);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.O, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 4.3
    @Test
    public void testOccupiedCellMove() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        sosGame.makeMove(3,4);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.S, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }
}