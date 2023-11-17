package sprint4_0.test;

import org.junit.Before;
import org.junit.Test;
import sprint4_0.product.SOSGame;
import sprint4_0.product.SimpleComputerGame;

public class testComputerPlayer {
    private SOSGame sosGame;
    @Before
    public void setUp() throws Exception{
        sosGame = new SimpleComputerGame();
    }

    //acceptance criteria 8.1
    @Test
    public void testRandomComputerMove() {
        //simple computer vs human
        //general computer vs human
        //simple computer vs computer
        //general computer vs computer

    }

    //acceptance criteria 8.2
    @Test
    public void testOutsideRangeSelection() {

    }
}