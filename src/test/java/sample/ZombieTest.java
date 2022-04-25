package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZombieTest {
    Zombie zombie;

    @BeforeEach
    public void setUp() {
        zombie = new Zombie(200, 200, -5, 50, 100, 250, 0, 1);
    }

    // Test that act on zombie will move zombie to left
    @Test
    public void testActValid(){
        Assertions.assertEquals(200, zombie.getX());
        zombie.act();
        Assertions.assertEquals(195, zombie.getX());
    }

    // Test that act on zombie at the limit will not move zombie
    // Fails, still moves zombie
    @Test
    public void testActEqualLimit(){
        zombie.setX(-50);
        Assertions.assertEquals(150, zombie.getX());
        zombie.act();
        Assertions.assertEquals(150, zombie.getX());
    }

    // Test that act on zombie past the limit will not move zombie
    // Fails, still moves zombie
    @Test
    public void testActPastLimit(){
        zombie.setX(-51);
        Assertions.assertEquals(149, zombie.getX());
        zombie.act();
        Assertions.assertEquals(149, zombie.getX());
    }

    // Test that act on dead zombie will throw exception
    // Fails, still acts
    @Test
    public void testActDead(){
        zombie.setDead(true);
        zombie.act();
        Assertions.assertThrows(Exception.class, () -> zombie.act());
    }

    // Test that decreasing health but not enough to kill zombie works
    @Test
    public void testDecreaseHealthAlive() {
        Assertions.assertEquals(100, zombie.getHealth());
        zombie.decreaseHealth(30);
        Assertions.assertEquals(70, zombie.getHealth());
        Assertions.assertFalse(zombie.isDead());
    }

    // Test that decreasing health just enough to kill zombie works
    @Test
    public void testDecreaseHealthExactDead() {
        Assertions.assertEquals(100, zombie.getHealth());
        zombie.decreaseHealth(100);
        Assertions.assertTrue(zombie.isDead());
    }

    // Test that decreasing health more than enough to kill zombie works
    @Test
    public void testDecreaseHealthOverDead() {
        Assertions.assertEquals(100, zombie.getHealth());
        zombie.decreaseHealth(120);
        Assertions.assertTrue(zombie.isDead());
    }

    // Test that decreasing health by negative amount will not work
    // Fails, increases health
    @Test
    public void testDecreaseHealthNegative() {
        Assertions.assertEquals(100, zombie.getHealth());
        Assertions.assertThrows(Exception.class, () -> zombie.decreaseHealth(-1));
    }

    // Fails. Last attack not initialized correctly
    @Test
    public void testGetLastAttack() {
        Assertions.assertEquals(250, zombie.getLastattack());
    }

    @Test
    public void testSetLastAttack() {
        zombie.setLastattack(80);
        Assertions.assertEquals(80, zombie.getLastattack());
    }

    @Test
    public void testSetAttackWaitingTime() {
        Assertions.assertEquals(1, zombie.get_attack_waiting_time());
        zombie.set_attack_waiting_time(2);
        Assertions.assertEquals(2, zombie.get_attack_waiting_time());
    }

    // Tests if zombie can be set to move right
    // Fails, still sets
    @Test
    public void testSetSpeedRight() {
        Assertions.assertEquals(-5, zombie.getSpeed());
        Assertions.assertThrows(Exception.class, () -> zombie.setSpeed(5));
    }

    // General Actor tests

    @Test
    public void testSetDead() {
        zombie.setDead(true);
        Assertions.assertTrue(zombie.isDead());
        zombie.setDead(false);
        Assertions.assertFalse(zombie.isDead());
    }

    @Test
    public void testSetSpeed() {
        Assertions.assertEquals(-5, zombie.getSpeed());
        zombie.setSpeed(-3);
        Assertions.assertEquals(-3, zombie.getSpeed());
    }

    @Test
    public void testSetX() {
        Assertions.assertEquals(200, zombie.getX());
        zombie.setX(22);
        Assertions.assertEquals(222, zombie.getX());
    }

    @Test
    public void testSetY() {
        Assertions.assertEquals(200, zombie.getY());
        zombie.setY(194);
        Assertions.assertEquals(394, zombie.getY());
    }

    @Test
    public void testGetRow() {
        Assertions.assertEquals(0, zombie.getRow());
    }

    @Test
    public void testGetDamage() {
        Assertions.assertEquals(50, zombie.getDamage());
    }

}
