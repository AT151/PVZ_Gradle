package sample;

import org.junit.jupiter.api.Test;
import sample.Peashooter;
import sample.Plant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlantTest {
    @Test
    public void decreaseHealthTest(){
        Plant plant = new Peashooter(1,1,1,1);

        plant.decreaseHealth(99);

        assertEquals( plant.getHealth(), 1);

        plant.decreaseHealth(1);

        assertEquals( plant.getHealth(), 0);

        assertTrue(plant.isDead());
    }

    @Test
    public void initializePlants() {
        Plant plant = new Peashooter(1,1,1,1);

        assertEquals(plant.getCol(), 1);
        assertEquals(plant.getRow(), 1);
        assertEquals(plant.getX(), 1);
        assertEquals(plant.getY(), 1);
        assertEquals(plant.getPrice(), 100);
        assertEquals(plant.getHealth(), 100);
        assertEquals(plant.getSpeed(), 0);
        assertEquals(plant.getWaitingtime(), 10);

    }

}
