package unit03;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import toys.Doll;
import toys.Robot;

public class RobotTest {
    @Test
    public void testChargeRobot() {
        Robot robot = new Robot("1234567", 24.99, 0, "Beep-Boop");
        robot.chargeRobot();
        assertEquals(1, robot.getCharge());
    }

    @Test
    public void testPlay1() {
        Robot robot = new Robot("7654321", 19.99, 50, "Sci-Fi Sounds");
        
        
    }
    @Test
    public void testPlay2() {
        Doll doll = new Doll("0987654", 12.99, "Brunette", "Brown", new String[]{"Hi there!", "Let's play!"});

    }
}