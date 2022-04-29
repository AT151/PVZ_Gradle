package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CherryBombTest {
    @Test
    public void initializePlants() {
        Cherrybomb cherrybomb = new Cherrybomb(1,1,1,1, 10);

        assertEquals(cherrybomb.getCol(), 1);
        assertEquals(cherrybomb.getRow(), 1);
        assertEquals(cherrybomb.getX(), 1);
        assertEquals(cherrybomb.getY(), 1);
        assertEquals(cherrybomb.getPrice(), 150);
        assertEquals(cherrybomb.getHealth(), 100);
        assertEquals(cherrybomb.getSpeed(), 0);
        assertEquals(cherrybomb.getWaitingtime(), 15);

        assertEquals(cherrybomb.getEffectedtiles(), 1);
        assertEquals(cherrybomb.get_last_used(), 10);


    }

    @Test
    public void testAct() {
        Cherrybomb cherrybomb = new Cherrybomb(1,1,1,1, 10);

        assertEquals(cherrybomb.getCol(), 1);
        assertEquals(cherrybomb.getRow(), 1);
        assertEquals(cherrybomb.getX(), 1);
        assertEquals(cherrybomb.getY(), 1);

        cherrybomb.act();

        assertEquals(cherrybomb.getCol(), 1);
        assertEquals(cherrybomb.getRow(), 1);
        assertEquals(cherrybomb.getX(), 1);
        assertEquals(cherrybomb.getY(), 1);
    }

    @Test
    public void testLastAdded() {
        Cherrybomb cherrybomb = new Cherrybomb(1,1,1,1, 10);
        assertEquals(Cherrybomb.getLastadded(), 0L);

        Cherrybomb.setLastadded(1);
        assertEquals(Cherrybomb.getLastadded(), 1L);

    }
}
