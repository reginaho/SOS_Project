package sprint2_1.test;

import org.junit.Before;
import org.junit.Test;
import sprint2_1.product.SOSGame;

import static org.junit.Assert.assertEquals;

public class testMoveGeneral {
    private SOSGame sosGame;

    @Before
    public void setUp() throws Exception {
        int userInput = 9;

        sosGame = new SOSGame();
        sosGame.updateGameType(SOSGame.GameType.GENERAL_GAME);
        sosGame.initGame(userInput, userInput);
    }

    //acceptance criteria 5.1
    @Test
    public void testGeneraleMoveS() {
        sosGame.updateLeftPlayer(SOSGame.Cell.S);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.S, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 5.2
    @Test
    public void testGeneralMoveO() {
        sosGame.updateLeftPlayer(SOSGame.Cell.O);
        sosGame.makeMove(3,4);
        assertEquals(SOSGame.Cell.O, sosGame.getCell(3,4));
        assertEquals(0, sosGame.getTurn()%2);
    }

    //acceptance criteria 5.3
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