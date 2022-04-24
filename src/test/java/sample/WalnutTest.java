package sample;

import org.junit.jupiter.api.Test;
import sample.Peashooter;
import sample.Walnut;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalnutTest {
    @Test
    public void initializePlants() {
        Walnut walnut = new Walnut(1,1,1,1);

        assertEquals(walnut.getCol(), 1);
        assertEquals(walnut.getRow(), 1);
        assertEquals(walnut.getX(), 1);
        assertEquals(walnut.getY(), 1);
        assertEquals(walnut.getPrice(), 50);
        assertEquals(walnut.getHealth(), 100);
        assertEquals(walnut.getSpeed(), 0);
        assertEquals(walnut.getWaitingtime(), 10);


    }

    @Test
    public void testAct() {
        Walnut walnut = new Walnut(1,1,1,1);
        assertEquals(walnut.getCol(), 1);
        assertEquals(walnut.getRow(), 1);
        assertEquals(walnut.getX(), 1);
        assertEquals(walnut.getY(), 1);

        walnut.act();

        assertEquals(walnut.getCol(), 1);
        assertEquals(walnut.getRow(), 1);
        assertEquals(walnut.getX(), 1);
        assertEquals(walnut.getY(), 1);
    }

    @Test
    public void testLastAdded() {
        Walnut walnut = new Walnut(1,1,1,1);
        assertEquals(Walnut.getLastadded(), 0L);


        Walnut.setLastadded(1);
        assertEquals(Walnut.getLastadded(), 1L);

    }
}
