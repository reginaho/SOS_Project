package sprint4_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint3_0.product.SOSGame;
import sprint3_0.product.SimpleGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class testGameStart {
    private SOSGame sosGame;
    @Before
    public void setUp() throws Exception{
        sosGame = new SimpleGame();
    }

    //acceptance criteria 3.1
    @Test
    public void testSuccessfulStart() {
        int userInput = 9;

        sosGame.initGame(userInput, userInput);
        assertEquals(SOSGame.GameType.SIMPLE_GAME, sosGame.getGameType());
        assertEquals(9, sosGame.getTotalColumns());
        assertEquals(9, sosGame.getTotalRows());
    }

    //acceptance criteria 3.2
    @Test
    public void testUnsuccessfulStart() {
        int userInput = 14;
        assertFalse(sosGame.initGame(userInput, userInput));
    }
}