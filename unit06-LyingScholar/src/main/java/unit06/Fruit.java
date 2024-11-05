package unit06;

import java.util.Collections;
import java.util.LinkedList;

public class Fruit implements Comparable<Fruit>{
    private String name;
    private double price;

    public Fruit(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getNsme(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return name + " $" + price;
    }

    @Override
    public int compareTo(Fruit o){
        if (this.name.toLowerCase().compareTo(o.name.toLowerCase()) == 0){
            if(this.price < o.price){
                return -1;
            } else if(this.price > o.price){
                return 1;
            } else{
                return 0;
            }
        }else{
            return this.name.toLowerCase().compareTo(o.name.toLowerCase());
        }
    }

    public static void main(String[] args) {
        LinkedList<Fruit> fruitList = new LinkedList<>();
        fruitList.add(new Fruit("Apple", 1.29));
        fruitList.add(new Fruit("Banana", 0.79));
        fruitList.add(new Fruit("Pear", 1.69));
        fruitList.add(new Fruit("banana", 0.59));

        System.out.println("\n" + fruitList);
        
        Collections.sort(fruitList);
        System.out.println("\n" + fruitList);
        System.out.println();

    }
}
