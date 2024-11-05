package toys;

import java.util.Arrays;
import java.util.Random;

public class ActionFigure extends Toy {
    private final String hairColor;
    private final String eyeColor;
    private final String[] sayings;
    private final boolean kungFuGrip;

    public ActionFigure(String productCode, double MSRP, String hairColor, String eyeColor, String[] sayings, boolean kungFuGrip) {
        super(productCode, "Action Figure", MSRP);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.sayings = sayings;
        this.kungFuGrip = kungFuGrip;
    }

    public ActionFigure(double MSRP, String hairColor, String eyeColor, String[] sayings, boolean kungFuGrip) {
        super(getProductCode(), "Action Figure", MSRP);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.sayings = sayings;
        this.kungFuGrip = kungFuGrip;
    }

    public void playAction() {
        System.out.println("Action of action figure");
    }

    @Override
    public void play() {
        System.out.println("Playing with action figure");
    }
    
    private static String getProductCode() {
        Random rand = new Random();
        int randomNumber = 1000000 + rand.nextInt(9000000);
        return Integer.toString(randomNumber);
    }
    @Override
    public String toString() {
        return super.toString() + "\nHair Color: " + hairColor + "\nEye Color: " + eyeColor + "\nSayings: " + Arrays.toString(sayings) + "\nKung-Fu Grip: " + kungFuGrip;
    }
}