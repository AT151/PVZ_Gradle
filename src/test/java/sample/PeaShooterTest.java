package sample;

import org.junit.jupiter.api.Test;
import sample.Peashooter;
import sample.Plant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PeaShooterTest {
    @Test
    public void initializePlants() {
        Peashooter peashooter = new Peashooter(1,1,1,1);

        assertEquals(peashooter.getCol(), 1);
        assertEquals(peashooter.getRow(), 1);
        assertEquals(peashooter.getX(), 1);
        assertEquals(peashooter.getY(), 1);
        assertEquals(peashooter.getPrice(), 100);
        assertEquals(peashooter.getHealth(), 100);
        assertEquals(peashooter.getSpeed(), 0);
        assertEquals(peashooter.getWaitingtime(), 10);
        assertEquals(peashooter.getBulletwaitingtime(), 2);
        assertEquals(peashooter.getDamage(), 25);
        assertEquals(peashooter.getLastbulletfired(), 0);

    }

    @Test
    public void testAct() {
        Peashooter peashooter = new Peashooter(1,1,1,1);
        assertEquals(peashooter.getCol(), 1);
        assertEquals(peashooter.getRow(), 1);
        assertEquals(peashooter.getX(), 1);
        assertEquals(peashooter.getY(), 1);

        peashooter.act();

        assertEquals(peashooter.getCol(), 1);
        assertEquals(peashooter.getRow(), 1);
        assertEquals(peashooter.getX(), 1);
        assertEquals(peashooter.getY(), 1);
    }

    @Test
    public void testLastAdded() {
        Peashooter peashooter = new Peashooter(1,1,1,1);
        assertEquals(Peashooter.getLastadded(), 0L);


        Peashooter.setLastadded(1);
        assertEquals(Peashooter.getLastadded(), 1L);

    }
}
