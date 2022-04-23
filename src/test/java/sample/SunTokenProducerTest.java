package sample;

import org.junit.jupiter.api.Test;
import sample.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SunTokenProducerTest {

    @Test
    public void testInitializeSunTokenProducer() {
        SunTokenProducer sunTokenProducer = new SunFlower(1,1,1,1);

        assertEquals(sunTokenProducer.getCol(), 1);
        assertEquals(sunTokenProducer.getRow(), 1);
        assertEquals(sunTokenProducer.getX(), 1);
        assertEquals(sunTokenProducer.getY(), 1);
        assertEquals(sunTokenProducer.getPrice(), 50);
        assertEquals(sunTokenProducer.getHealth(), 100);
        assertEquals(sunTokenProducer.getSpeed(), 0);
        assertEquals(sunTokenProducer.getWaitingtime(), 10);
        assertEquals(sunTokenProducer.getTokenwaitingtime(), 15);
        assertEquals(sunTokenProducer.getLasttokenadded(), 0);
        assertEquals(sunTokenProducer.getSunproduction(), 50);
    }

    @Test
    public void testSetLasttokenadded() {
        SunTokenProducer sunTokenProducer = new SunFlower(1,1,1,1);
        sunTokenProducer.setLasttokenadded(10);
        assertEquals(sunTokenProducer.getLasttokenadded(), 10);
    }



}
