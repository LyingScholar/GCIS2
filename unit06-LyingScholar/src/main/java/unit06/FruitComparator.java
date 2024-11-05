package unit06;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FruitComparator implements Comparator<Fruit>{

    @Override
    public int compare(Fruit o1, Fruit o2){
        if(o1.getPrice() < o2.getPrice()){
            return -1;
        } else if(o1.getPrice() > o2.getPrice()){
            return 1;
        } else{
            return o1.getNsme().toLowerCase().compareTo(o2.getNsme().toLowerCase());
        }
    }

    public static void main(String[] args) {
        LinkedList<Fruit> fruitList = new LinkedList<>();
        fruitList.add(new Fruit("banana", 0.59));
        fruitList.add(new Fruit("Pear", 1.69));

        fruitList.add(new Fruit("Banana", 0.79));
        fruitList.add(new Fruit("Apple", 1.69));
        System.out.println("\n" + fruitList);
        
        Collections.sort(fruitList);
        System.out.println("\n" + fruitList);

        Collections.sort(fruitList, new FruitComparator());
        System.out.println("\n" + fruitList);

        System.out.println();

    }
}