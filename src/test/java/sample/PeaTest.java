package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PeaTest {
    Pea pea;

    @BeforeEach
    public void setUp() {
        pea = new Pea(0, 0, 0);
    }

    // Test that bullet goes to right by speed when under limit
    @Test
    public void testActUnderLimit() {
        Assertions.assertEquals(0, pea.getX());
        pea.act();
        Assertions.assertEquals(pea.getSpeed(), pea.getX());
    }

    // test that bullet doesnt move when equal limit
    @Test
    public void testActEqualLimit() {
        pea.setX(1000);
        Assertions.assertEquals(1000, pea.getX());
        pea.act();
        Assertions.assertEquals(1000, pea.getX());
    }

    // test that bullet doesnt move when over limit
    @Test
    public void testActOverLimit() {
        pea.setX(1001);
        Assertions.assertEquals(1001, pea.getX());
        pea.act();
        Assertions.assertEquals(1001, pea.getX());
    }

    @Test
    public void testGetDamage() {
        Assertions.assertEquals(25, pea.getDamage());
    }

    @Test
    public void testSetSpeed() {
        pea.setSpeed(3);
        Assertions.assertEquals(3, pea.getSpeed());
    }

    @Test
    public void testSetX() {
        pea.setX(22);
        Assertions.assertEquals(22, pea.getX());
    }

    @Test
    public void testSetY() {
        pea.setY(194);
        Assertions.assertEquals(194, pea.getY());
    }

}
