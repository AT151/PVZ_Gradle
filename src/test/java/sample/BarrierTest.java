package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarrierTest {
    @Test
    public void initializeBarrier(){
        Barrier barrier = new Walnut(1,1,1,1);

        assertEquals(barrier.getCol(), 1);
        assertEquals(barrier.getRow(), 1);
        assertEquals(barrier.getX(), 1);
        assertEquals(barrier.getY(), 1);
        assertEquals(barrier.getPrice(), 50);
        assertEquals(barrier.getHealth(), 100);
        assertEquals(barrier.getSpeed(), 0);
        assertEquals(barrier.getWaitingtime(), 10);

    }

}
