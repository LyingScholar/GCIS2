package toys;
import java.util.Random;

public class Robot extends Toy {
    private int charge;
    private final String sound;

    public Robot(String productCode, double MSRP, int charge, String sound) {
        super(productCode, "Robot", MSRP);
        this.charge = charge;
        this.sound = sound;
    }

    public Robot(double MSRP, int charge, String sound) {
        super(getProductCode(), "Robot", MSRP);
        this.charge = charge;
        this.sound = sound;
    }

    public void chargeRobot() {
        System.out.println("Charging Robot");
    }
    public int getCharge() {
        return charge;
    }


    @Override
    public void play() {
        System.out.println("Playing with Robot");
    }
    
    private static String getProductCode() {
        Random rand = new Random();
        int randomNumber = 1000000 + rand.nextInt(9000000);
        return Integer.toString(randomNumber);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCharge: " + charge + "\nSound: " + sound;
    }
}