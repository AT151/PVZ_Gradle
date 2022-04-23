package sample;

import org.junit.jupiter.api.Test;
import sample.SunFlower;
import sample.Walnut;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SunFlowerTest {
    @Test
    public void initializeSunFlower() {
        SunFlower sunFlower = new SunFlower(1,1,1,1);


        assertEquals(sunFlower.getCol(), 1);
        assertEquals(sunFlower.getRow(), 1);
        assertEquals(sunFlower.getX(), 1);
        assertEquals(sunFlower.getY(), 1);
        assertEquals(sunFlower.getPrice(), 50);
        assertEquals(sunFlower.getHealth(), 100);
        assertEquals(sunFlower.getSpeed(), 0);
        assertEquals(sunFlower.getWaitingtime(), 10);
        assertEquals(sunFlower.getTokenwaitingtime(), 15);
        assertEquals(sunFlower.getLasttokenadded(), 0);
        assertEquals(sunFlower.getSunproduction(), 50);



    }

    @Test
    public void testAct() {
        SunFlower sunFlower = new SunFlower(1,1,1,1);
        assertEquals(sunFlower.getCol(), 1);
        assertEquals(sunFlower.getRow(), 1);
        assertEquals(sunFlower.getX(), 1);
        assertEquals(sunFlower.getY(), 1);

        sunFlower.act();

        assertEquals(sunFlower.getCol(), 1);
        assertEquals(sunFlower.getRow(), 1);
        assertEquals(sunFlower.getX(), 1);
        assertEquals(sunFlower.getY(), 1);
    }

    @Test
    public void testLastAdded() {
        SunFlower sunFlower = new SunFlower(1,1,1,1);
        assertEquals(SunFlower.getLastadded(), 0L);


        SunFlower.setLastadded(1);
        assertEquals(SunFlower.getLastadded(), 1L);

    }
}
