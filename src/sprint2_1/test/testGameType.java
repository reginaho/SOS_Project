package sprint2_1.test;

import org.junit.Before;
import org.junit.Test;
import sprint2_1.product.SOSGame;

import static org.junit.Assert.assertEquals;

public class testGameType {
    private SOSGame sosGame;
    @Before
    public void setUp() throws Exception{
        sosGame = new SOSGame();
        sosGame.initGame(9, 9);
    }

    //acceptance criteria 2.1
    @Test
    public void testSimpleGame() {
        sosGame.updateGameType(SOSGame.GameType.SIMPLE_GAME);
        assertEquals(SOSGame.GameType.SIMPLE_GAME, sosGame.getGameType());
    }

    //acceptance criteria 2.2
    @Test
    public void testGeneralGame() {
        sosGame.updateGameType(SOSGame.GameType.GENERAL_GAME);
        assertEquals(SOSGame.GameType.GENERAL_GAME, sosGame.getGameType());
    }
}