package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombTest {
    @Test
    public void initializeBomb(){
        Bomb bomb = new Cherrybomb(1,1,1,1, 10);

        assertEquals(bomb.getCol(), 1);
        assertEquals(bomb.getRow(), 1);
        assertEquals(bomb.getX(), 1);
        assertEquals(bomb.getY(), 1);
        assertEquals(bomb.getPrice(), 150);
        assertEquals(bomb.getHealth(), 100);
        assertEquals(bomb.getSpeed(), 0);
        assertEquals(bomb.getWaitingtime(), 15);
        assertEquals(bomb.getEffectedtiles(), 1);
        assertEquals(bomb.get_last_used(), 10);

    }

    @Test
    public void testSetLastUsed() {
        Bomb bomb = new Cherrybomb(1,1,1,1, 10);
        bomb.set_last_used(20);
        assertEquals(bomb.get_last_used(), 20);
    }
}
