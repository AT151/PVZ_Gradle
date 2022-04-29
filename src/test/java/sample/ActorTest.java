package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ActorTest {
    @Test
    public void testInitializeActor(){
        Actor barrier = new Walnut(1,1,1,1);

        assertEquals(barrier.getX(), 1);
        assertEquals(barrier.getY(), 1);
        assertEquals(barrier.getSpeed(), 0);
        assertFalse(barrier.isDead());


    }

    @Test
    public void testImageView() throws FileNotFoundException {
        Actor barrier = new Walnut(1,1,1,1);
        assertNull(barrier.getImview());

        javafx.scene.image.ImageView sun=new ImageView();
        sun.setImage(new Image(new FileInputStream("src/test/resources/Sun.png")));

        barrier.setImview(sun);

        assertEquals(barrier.getImview(), sun);

    }

    @Test
    public void testSpeed() throws FileNotFoundException {
        Actor barrier = new Walnut(1,1,1,1);
        assertEquals(barrier.getSpeed(), 0);
        barrier.setSpeed(10);

        assertEquals(barrier.getSpeed(), 10);

    }
}
