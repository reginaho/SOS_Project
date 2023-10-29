package sprint3_0.test;

import org.junit.Test;
import sprint3_0.product.GeneralGame;
import sprint3_0.product.SOSGame;
import sprint3_0.product.SimpleGame;

import static org.junit.Assert.assertEquals;

public class testGameType {
    private SOSGame sosGame;

    //acceptance criteria 2.1
    @Test
    public void testSimpleGame() {
        sosGame = new SimpleGame();
        sosGame.initGame(9, 9);
        assertEquals(SOSGame.GameType.SIMPLE_GAME, sosGame.getGameType());
    }

    //acceptance criteria 2.2
    @Test
    public void testGeneralGame() {
        sosGame = new GeneralGame();
        sosGame.initGame(9, 9);
        assertEquals(SOSGame.GameType.GENERAL_GAME, sosGame.getGameType());
    }
}