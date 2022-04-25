package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BulletTest {
    Bullet bullet;

    @BeforeEach
    public void setUp() {
        bullet = new Bullet(0, 0, 50, 0, 60);
    }

    // Test that bullet goes to right by speed when under limit
    @Test
    public void testActUnderLimit() {
        Assertions.assertEquals(0, bullet.getX());
        bullet.act();
        Assertions.assertEquals(bullet.getSpeed(), bullet.getX());
    }

    // test that bullet doesnt move when equal limit
    @Test
    public void testActEqualLimit() {
        bullet.setX(1000);
        Assertions.assertEquals(1000, bullet.getX());
        bullet.act();
        Assertions.assertEquals(1000, bullet.getX());
    }

    // test that bullet doesnt move when over limit
    @Test
    public void testActOverLimit() {
        bullet.setX(1001);
        Assertions.assertEquals(1001, bullet.getX());
        bullet.act();
        Assertions.assertEquals(1001, bullet.getX());
    }

    @Test
    public void testGetDamage() {
        Assertions.assertEquals(60, bullet.getDamage());
    }

    // General Actor tests

    @Test
    public void testSetDead() {
        bullet.setDead(true);
        Assertions.assertTrue(bullet.isDead());
        bullet.setDead(false);
        Assertions.assertFalse(bullet.isDead());
    }

    @Test
    public void testSetSpeed() {
        bullet.setSpeed(3);
        Assertions.assertEquals(3, bullet.getSpeed());
    }

    @Test
    public void testSetX() {
        bullet.setX(22);
        Assertions.assertEquals(22, bullet.getX());
    }

    @Test
    public void testSetY() {
        bullet.setY(194);
        Assertions.assertEquals(194, bullet.getY());
    }

    @Test
    public void testGetRow() {
        Assertions.assertEquals(0, bullet.getRow());
    }

}
