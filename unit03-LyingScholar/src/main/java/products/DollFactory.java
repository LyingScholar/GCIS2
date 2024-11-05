package products;

import java.util.Random;

import toys.Doll;
import toys.Toy;

public class DollFactory extends Factory {

    public DollFactory(){
        
    }
    public Toy createDoll(String productCode, double MSRP, String hairColor, String eyeColor) {
        return new Doll(productCode, MSRP, hairColor, eyeColor);
    }

    @Override
    public Toy manufactureProduct(){
        return createRandomDoll();

    }

    public Toy createRandomDoll() {
        String productCode = generateProductCode();
        double randomMSRP = generateRandomMSRP(5, 30);
        String randomHairColor = generateRandomColor(new String[]{"Blonde", "Brown", "Black", "Red"});
        String randomEyeColor = generateRandomColor(new String[]{"Blue", "Brown", "Green"});
        return new Doll(productCode, randomMSRP, randomHairColor, randomEyeColor);
    }
    private String generateProductCode() {
        Random rand = new Random();
        int randomNumber = 1000000 + rand.nextInt(9000000);
        return Integer.toString(randomNumber);
    }
    private double generateRandomMSRP(int min, int max) {
        Random rand = new Random();
        double randomMSRP = min + (max - min) * rand.nextDouble();
        return Math.floor(randomMSRP) + 0.99;
    }
    private String generateRandomColor(String[] colors) {
        Random rand = new Random();
        int index = rand.nextInt(colors.length);
        return colors[index];
    }
}