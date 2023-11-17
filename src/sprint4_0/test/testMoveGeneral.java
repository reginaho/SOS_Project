package sprint4_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint4_0.product.GeneralComputerGame;
import sprint4_0.product.SOSGame;

import static org.junit.Assert.assertEquals;

public class testMoveGeneral {
    private SOSGame sosGame;

    @Before
    public void setUp() throws Exception {
        int userInput = 9;

        sosGame = new GeneralComputerGame();
        sosGame.initGame(userInput, userInput);
    }

    //acceptance criteria 6.1
    @Test
    public void testGeneralMoveS() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.S, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 6.2
    @Test
    public void testGeneralMoveO() {
        sosGame.updateLeftPlayer(SOSGame.Cell.O);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.O, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 6.3
    @Test
    public void testOccupiedCellMove() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        sosGame.makeMove(3,4);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.S, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 6.4
    @Test
    public void testOccupiedContinuedTurn() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        sosGame.makeMove(3,4);
        sosGame.makeMove(3,5);
        sosGame.makeMove(3,6);
        assertEquals(1, sosGame.getTurn()%2);
    }
}