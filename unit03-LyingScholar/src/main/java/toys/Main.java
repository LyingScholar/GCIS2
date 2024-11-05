package toys;

import products.Complex;
import products.DollFactory;
import products.Factory;
import products.RobotFactory;
import products.Truck;

public class Main {
    public static void main(String[] args) {
    

        Factory[] factories = {new RobotFactory(), new DollFactory()};

        Complex complex = new Complex(factories);

        Truck truck = new Truck(5);

        complex.loadTruck(truck);

        truck.unload();
    }
}