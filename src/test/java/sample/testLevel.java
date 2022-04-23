package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class testLevel {
    Level level;

    @BeforeEach
    public void setUp() {
        level = new Level();
        level.setName("User");
        level.set_level(1);
    }

    // Tests adding new peashooter, but can't afford (since we can't access private sun_c)
    @Test
    public void testAddNewPlantPeashooter() throws FileNotFoundException {
        level.lastclick = "peashooter_menu";
        Assertions.assertEquals(false,  level.addnewplant(0, 0));
    }

    // Tests adding new sunflower, but can't afford (since we can't access private sun_c)
    @Test
    public void testAddNewPlantSunflower() throws FileNotFoundException {
        level.lastclick = "sunflower_menu";
        Assertions.assertEquals(false,  level.addnewplant(0, 0));
    }

    // Tests adding new walnut, but can't afford (since we can't access private sun_c)
    @Test
    public void testAddNewPlantWalnut() throws FileNotFoundException {
        level.lastclick = "walnut_menu";
        Assertions.assertEquals(false,  level.addnewplant(0, 0));
    }

    // Tests adding new cherrybomb, but can't afford (since we can't access private sun_c)
    @Test
    public void testAddNewPlantCherrybomb() throws FileNotFoundException {
        level.lastclick = "cherrybomb_menu";
        Assertions.assertEquals(false,  level.addnewplant(0, 0));
    }

    // Tests adding new plant, but plant name invalid
    @Test
    public void testAddNewPlantInvalid() throws FileNotFoundException {
        level.lastclick = "apple_menu";
        Assertions.assertEquals(false,  level.addnewplant(0, 0));
    }

    // Tests distance calculation with positive values
    @Test
    public void testDistPos()  {
        Actor a = new Zombie(200, 200, -5, 50, 100, 250, 2, 1);
        Actor b = new Lawnmower(100, 100, 1);
        Assertions.assertEquals(141.42135623731, level.dist(a, b), 0.0001);
    }

    // Tests distance calculation with negative values
    @Test
    public void testDistNeg()  {
        Actor a = new Zombie(-200, -200, -5, 50, 100, 250, 2, 1);
        Actor b = new Lawnmower(-100, -100, 1);
        Assertions.assertEquals(141.42135623731, level.dist(a, b), 0.0001);
    }

    // Tests distance calculation with mix of positive and negative values
    @Test
    public void testDistMix()  {
        Actor a = new Zombie(200, -200, -5, 50, 100, 250, 2, 1);
        Actor b = new Lawnmower(-100, 100, 1);
        Assertions.assertEquals(424.26406871193, level.dist(a, b), 0.0001);
    }

    @Test
    public void testSetName() {
        Assertions.assertEquals("User", level.getName());
        level.setName("Another");
        Assertions.assertEquals("Another", level.getName());
    }

    // Throw exception because of JavaFX elements not initialized
//    // Test helper with x and y under cutoff thresholds
//    @Test
//    public void testHelperLowXLowY() {
//        level.menu_click = true;
//        level.helper(0, 0);
//        Assertions.assertFalse(level.menu_click);
//    }
//
//    // Test helper with x and y over cutoff thresholds
//    @Test
//    public void testHelperMedXMedY() {
//        level.menu_click = true;
//        level.helper(77, 98);
//        Assertions.assertFalse(level.menu_click);
//    }
//
//    // Test helper with x and y over twice cutoff thresholds
//    @Test
//    public void testHelperHighXHighY() {
//        level.menu_click = true;
//        level.helper(154, 198);
//        Assertions.assertFalse(level.menu_click);
//    }

}
