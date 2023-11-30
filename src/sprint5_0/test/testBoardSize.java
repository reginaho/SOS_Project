package sprint5_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint4_0.product.SOSGame;
import sprint4_0.product.SimpleComputerGame;

import static org.junit.Assert.*;

public class testBoardSize {
    private SOSGame sosGame;
    @Before
    public void setUp() throws Exception{
        sosGame = new SimpleComputerGame();
    }

    //acceptance criteria 1.1
    @Test
    public void testBoardSizeSelection() {
        int userInput = 9;
        sosGame.initGame(userInput, userInput);
        assertEquals(9, sosGame.getTotalColumns());
        assertEquals(9, sosGame.getTotalRows());
    }

    //acceptance criteria 1.2
    @Test
    public void testOutsideRangeSelection() {
        int userInput = 14;
        sosGame.initGame(userInput, userInput);
        assertNotEquals(userInput,sosGame.getTotalColumns());
        assertNotEquals(userInput,sosGame.getTotalRows());
    }
}