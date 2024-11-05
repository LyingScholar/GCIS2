package products;

import toys.Toy;

public class Truck {
    private int capacity;
    private Toy[] load;
    private int currentLoad;

    public Truck(int capacity) {
        this.capacity = capacity;
        this.load = new Toy[capacity];
        this.currentLoad = 0;
        //this is literally just an index, NO STACKING HERE
    }

    public boolean isFull() {
        return currentLoad >= capacity;
    }

    public void load(Toy toy) {
        if (!isFull()) {
            load[currentLoad] = toy;
            System.out.println("Loaded Toy: " + toy.toString());
            currentLoad++;
        } else {
            System.out.println("Truck is already full. Cannot load more Toys.");
        }
    }



    public void unload() {
        if (currentLoad > 0) {
            Toy Toy = load[currentLoad - 1];
            System.out.println("Unloaded Toy: " + Toy.toString());
            load[currentLoad - 1] = null;
            currentLoad--;
            
        } else {
            System.out.println("Truck is already empty. Nothing to unload.");
        }
    }
}