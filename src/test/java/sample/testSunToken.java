package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testSunToken {
    SunToken sunToken;

    @BeforeEach
    public void setUp() {
        sunToken = new SunToken(0, 0, 30);
    }

    // Test that act increases Y by speed when y under limit
    @Test
    public void testActUnderLimit() {
        Assertions.assertEquals(0, sunToken.getY());
        sunToken.act();
        Assertions.assertEquals(sunToken.getSpeed(), sunToken.getY());
    }

    // Test that act does not change Y when Y is limit
    @Test
    public void testActEqualLimit() {
        sunToken.setY(30);
        Assertions.assertEquals(30, sunToken.getY());
        sunToken.act();
        Assertions.assertEquals(30, sunToken.getY());
    }

    // Test that act does not change Y when Y is over limit
    @Test
    public void testActOverLimit() {
        sunToken.setY(31);
        Assertions.assertEquals(31, sunToken.getY());
        sunToken.act();
        Assertions.assertEquals(31, sunToken.getY());
    }

    // Test that act does not work when sunToken is dead
    // Fails, still acts
    @Test
    public void testActDead() {
        sunToken.setDead(true);
        Assertions.assertEquals(0, sunToken.getY());
        Assertions.assertThrows(Exception.class, () -> sunToken.act());
    }

}
