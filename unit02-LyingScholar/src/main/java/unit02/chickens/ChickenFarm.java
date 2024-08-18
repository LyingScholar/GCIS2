package unit02.chickens;

import java.util.Scanner;

public class ChickenFarm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chickens on the farm: ");
        int numChickens = scanner.nextInt();

        for (int i = 0; i < numChickens; i++) {
            Chicken chicken = Chicken.generateRandomChicken();
            Egg egg = chicken.layEgg();
            System.out.println(chicken + ", laid " + egg + ".");
        }
        scanner.close();
    }
}