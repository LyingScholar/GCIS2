package products;

import java.util.Random;

import toys.Robot;
import toys.Toy;

public class RobotFactory extends Factory {
   
   public RobotFactory(){
   }
   public Toy createRobot(String productCode, double MSRP, int charge, String sound) {
      return new Robot(productCode, MSRP, charge, sound);
   }


// public Product manufactureProduct(){
//    String productCode = generateProductCode();
//    double randomMSRP = generateRandomMSRP(30, 100);
//    int randomCharge = generateRandomCharge();
//    String randomSound = generateRandomSound();
//    return new Product(productCode, "Robot", randomMSRP);

//   }
   @Override
   public Toy manufactureProduct(){
      return createRandomRobot();

   }

   public Toy createRandomRobot() {
      String productCode = generateProductCode();
      double randomMSRP = generateRandomMSRP(30, 100);
      int randomCharge = generateRandomCharge();
      String randomSound = generateRandomSound();
      return new Robot(productCode, randomMSRP, randomCharge, randomSound);
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
   private int generateRandomCharge() {
      return new Random().nextInt(100) + 1;
   }
   private String generateRandomSound() {
      String[] soundChoices = {"Beep", "Boop", "Whirr", "Click"};
      Random rand = new Random();
      return soundChoices[rand.nextInt(soundChoices.length)];
   }
}