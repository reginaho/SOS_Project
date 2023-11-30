package sprint5_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint4_0.product.SOSGame;
import sprint4_0.product.SimpleComputerGame;

import static org.junit.Assert.*;

public class testComputerPlayer {
    private SimpleComputerGame sosGame;
    @Before
    public void setUp() throws Exception{
        sosGame = new SimpleComputerGame();
        sosGame.initGame(10,10);
    }

    //acceptance criteria 8.1
    @Test
    public void testComputerMode() {
        sosGame.setLeftPlayerType(SOSGame.PlayerType.COMPUTER_PLAYER);
        assertEquals(SOSGame.PlayerType.COMPUTER_PLAYER, sosGame.getLeftPlayerType());
    }

    //acceptance criteria 8.2
    @Test
    public void testComputerSOSMove() {
        sosGame.setLeftPlayerType(SOSGame.PlayerType.COMPUTER_PLAYER);
        sosGame.makeMove();
        sosGame.updateRightPlayer(SOSGame.Cell.S);
        sosGame.makeMove(2,2);
        sosGame.makeMove();
        sosGame.updateRightPlayer(SOSGame.Cell.O);
        sosGame.makeMove(2,3);
        sosGame.makeMove();

        assertNotEquals(SOSGame.GameState.PLAYING, sosGame.getGameState());
    }
    //acceptance criteria 8.3
    @Test
    public void testComputerRandomMove() {
        sosGame.setLeftPlayerType(SOSGame.PlayerType.COMPUTER_PLAYER);
        assertTrue(sosGame.randomMove());
    }
}