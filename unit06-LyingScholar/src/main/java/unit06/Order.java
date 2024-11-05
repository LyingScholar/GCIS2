package unit06;

import java.util.PriorityQueue;

public class Order {
    PriorityQueue<Sushi> itemsList;
    private double totalCost;

    public Order() {
        this.itemsList = new PriorityQueue<Sushi>();
        this.totalCost = 0.0;
    }

    public void addSushi(Sushi sushi) {
        this.itemsList.add(sushi);
        this.totalCost += sushi.getPrice();
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public Sushi getNextSushi() {
        return this.itemsList.remove();
    }
}