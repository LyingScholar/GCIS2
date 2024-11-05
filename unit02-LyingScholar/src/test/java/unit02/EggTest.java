package unit02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unit02.chickens.Egg;
import unit02.chickens.EggColor;
import unit02.chickens.EggSize;

public class EggTest {
    @Test
    public void testCrackEgg() {
        Egg egg = new Egg(EggColor.BROWN, EggSize.LARGE);
        egg.crack();
        assertTrue(egg.toString().contains("cracked"));
    }

    @Test
    public void testEggToString() {
        Egg egg = new Egg(EggColor.WHITE, EggSize.JUMBO);
        String expectedString = "An uncracked JUMBO (2.5oz) WHITE egg";
        assertEquals(expectedString, egg.toString());
    }

    @Test
    public void testEqualEggs() {
        Egg egg1 = new Egg(EggColor.BROWN, EggSize.EXTRA_LARGE);
        Egg egg2 = new Egg(EggColor.BROWN, EggSize.EXTRA_LARGE);
        assertTrue(egg1.equals(egg2));
    }
}