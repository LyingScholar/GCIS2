package unit02;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unit02.chickens.Chicken;
import unit02.chickens.Egg;
import unit02.chickens.EggColor;
import unit02.chickens.EggSize;

public class ChickenTest {
    @Test
    public void testLayEgg() {
        Chicken chicken = new Chicken("Test Chicken", EggSize.EXTRA_LARGE, EggColor.BROWN);
        Egg egg = chicken.layEgg();
        assertNotNull(egg);
    }

    @Test
    public void testGenerateRandomChicken() {
        Chicken randomChicken = Chicken.generateRandomChicken();
        assertNotNull(randomChicken);
    }

    @Test
    public void testChickenToString() {
        Chicken chicken = new Chicken("Test Chicken", EggSize.EXTRA_LARGE, EggColor.BROWN);
        String expectedString = "Test Chicken, a chicken that lays EXTRA_LARGE BROWN eggs";
        assertEquals(expectedString, chicken.toString());
    }
}