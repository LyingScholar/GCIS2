package toys;

import java.util.Arrays;
import java.util.Random;

public class Doll extends Toy {
    private final String hairColor;
    private final String eyeColor;
    private final String[] sayings;

    public Doll(String productCode, double MSRP, String hairColor, String eyeColor, String[] sayings) {
        super(productCode, "Doll", MSRP);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.sayings = sayings;
    }

    public Doll(double MSRP, String hairColor, String eyeColor, String[] sayings) {
        super(getProductCode(), "Doll", MSRP);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.sayings = sayings;
    }

    public void pullString() {
        System.out.println("String pulled");
    }

    @Override
    public void play() {
        System.out.println("Playing with doll");
    }

    private static String getProductCode() {
        Random rand = new Random();
        int randomNumber = 1000000 + rand.nextInt(9000000);
        return Integer.toString(randomNumber);
    }


    @Override
    public String toString() {
        return super.toString() + "\nHair Color: " + hairColor + "\nEye Color: " + eyeColor + "\nSayings: " + Arrays.toString(sayings);
    }
}