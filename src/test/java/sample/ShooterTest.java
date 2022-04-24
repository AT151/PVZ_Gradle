package sample;

import org.junit.jupiter.api.Test;
import sample.Peashooter;
import sample.Shooter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShooterTest {
    @Test
    public void initializeShooter(){
        Shooter shooter = new Peashooter(1,1,1,1);

        assertEquals(shooter.getBulletwaitingtime(), 2);
        assertEquals(shooter.getDamage(), 25);
        assertEquals(shooter.getLastbulletfired(), 0);
    }

    @Test
    public void testSetLastbulletfired() {
        Shooter shooter = new Peashooter(1,1,1,1);
        shooter.setLastbulletfired(10);
        assertEquals(shooter.getLastbulletfired(), 10);
    }
}
