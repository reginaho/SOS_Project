package sprint2_1.test;

import org.junit.Before;
import org.junit.Test;
import sprint2_1.product.SOSGame;

import static org.junit.Assert.*;

public class testBoardSize {
    private SOSGame sosGame;
    @Before
    public void setUp() throws Exception{
        sosGame = new SOSGame();
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