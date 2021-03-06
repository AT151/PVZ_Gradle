package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LawnmowerTest {
    Lawnmower lawnmower;

    @BeforeEach
    public void SetUp() {
        lawnmower = new Lawnmower(0, 0, 0);
    }

    // Test that setting active works as expected
    @Test
    public void testSetActive() {
        Assertions.assertFalse(lawnmower.getActive());
        lawnmower.setActive(true);
        Assertions.assertTrue(lawnmower.getActive());
        lawnmower.setActive(false);
        Assertions.assertFalse(lawnmower.getActive());
    }

    // Test that calling act on active will increase x by speed amount
    @Test
    public void testActActive() {
        lawnmower.setActive(true);
        Assertions.assertEquals(0, lawnmower.getX());
        lawnmower.act();
        Assertions.assertEquals(lawnmower.getSpeed(), lawnmower.getX());
    }

    // Test that calling act() on inactive will increase x by speed amount and set to active
    // Fails, act still performs as if not active
    @Test
    public void testActInactive() {
        lawnmower.setActive(false);
        Assertions.assertEquals(0, lawnmower.getX());
        lawnmower.act();
        Assertions.assertEquals(lawnmower.getSpeed(), lawnmower.getX());
        Assertions.assertTrue(lawnmower.getActive());
    }

    // Test that calling act() on dead will throw exception
    // Fails, act still performs as if not dead
    @Test
    public void testActDead() {
        lawnmower.setDead(true);
        Assertions.assertEquals(0, lawnmower.getX());
        Assertions.assertThrows(Exception.class, () -> lawnmower.act());
    }

    // Test that calling act() at the limit will make lawnmower dead
    @Test
    public void testActEqualLimit() {
        lawnmower.setX(1000);
        lawnmower.act();
        Assertions.assertEquals(1000, lawnmower.getX());
        Assertions.assertTrue(lawnmower.isDead());
    }

    // Test that calling act() over the limit will make lawnmower dead
    @Test
    public void testActOverLimit() {
        lawnmower.setX(1001);
        lawnmower.act();
        Assertions.assertEquals(1001, lawnmower.getX());
        Assertions.assertTrue(lawnmower.isDead());
    }

    @Test
    public void testSetSpeed() {
        lawnmower.setSpeed(3);
        Assertions.assertEquals(3, lawnmower.getSpeed());
    }

    @Test
    public void testSetX() {
        lawnmower.setX(22);
        Assertions.assertEquals(22, lawnmower.getX());
    }

    @Test
    public void testSetY() {
        lawnmower.setY(194);
        Assertions.assertEquals(194, lawnmower.getY());
    }

    @Test
    public void testGetRow() {
        Assertions.assertEquals(0, lawnmower.getRow());
    }
}
