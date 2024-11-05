package products;

import java.util.Random;


public class Complex {
    private Factory[] factories;

    public Complex(Factory[] factories) {

        this.factories = factories;
    }
    public void loadTruck(Truck truck) {
        while (!truck.isFull()) {
            Factory randomFactory = getRandomFactory();//random factory FROM list, not NEW random factory
            if (randomFactory != null) {
                truck.load(randomFactory.manufactureProduct());
            } else {
                System.out.println("No factories available to load products.");
                break;
            }
        }
    }

    private Factory getRandomFactory() {
        if (factories != null && factories.length > 0) {
            Random rand = new Random();
            int index = rand.nextInt(factories.length); // Adjusted for array length, hopefully
            return factories[index];
        } else {
            return null;
        }
    }
}