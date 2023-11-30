package sprint5_0.test;

import org.junit.Test;
import sprint4_0.product.*;

import static org.junit.Assert.assertEquals;

public class testGameType {
    private SOSGame sosGame;

    //acceptance criteria 2.1
    @Test
    public void testSimpleGame() {
        sosGame = new SimpleComputerGame();
        sosGame.initGame(9, 9);
        assertEquals(SOSGame.GameType.SIMPLE_GAME, sosGame.getGameType());
    }

    //acceptance criteria 2.2
    @Test
    public void testGeneralGame() {
        sosGame = new GeneralComputerGame();
        sosGame.initGame(9, 9);
        assertEquals(SOSGame.GameType.GENERAL_GAME, sosGame.getGameType());
    }
}