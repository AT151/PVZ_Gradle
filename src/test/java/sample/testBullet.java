package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testBullet {
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

}
