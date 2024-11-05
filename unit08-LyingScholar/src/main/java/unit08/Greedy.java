package unit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import unit08.knapsack.Item;
import unit08.knapsack.ItemSets;
import unit08.knapsack.Knapsack;
import unit08.knapsack.ValueComparator;

public class Greedy {
    //make change method:
    public static List<Currency> makeChange(double price, double payment){
        //make a list of change using an ArrayList
        List<Currency> change = new ArrayList<>();
        //compute the amount of change: pyment - price
        double diff = payment - price;
        // count out each denomination of currency needed to make
            // change using a helper method, by decreasing currency
            // value.
            diff = countChange(diff,Currency.FIVES, change);
            diff = countChange(diff,Currency.DOLLAR, change);
            diff = countChange(diff,Currency.QUARTER, change);
            diff = countChange(diff,Currency.DIME, change);
            diff = countChange(diff,Currency.NICKEL, change);
            diff = countChange(diff,Currency.PENNY, change);
            // return change
            return change;

    }

    // helper method:
    public static double countChange(double amount, Currency currency,
    List<Currency> change){

        // using a denomination, Itake that amount out of the
        // change due and add it to the list, until you
        // cannot take that denomination out
        while(amount > currency.getValue()){
            change.add(currency);
            amount -= currency.getValue();
        }
    // return the difference.
    return amount;
    }

    public static void packItems(Knapsack knapsack, List<Item> items){
        // pack the lightest
        // sort items by ascending weight
        Collections.sort(items);
        // while the list has items
        while(items.size() > 0){
            // remove item from list
            Item item = items.remove(0);
            knapsack.pack(item);
            // add to backpack (reject if too heavy)
        }
    }

    
    public static void packMostValuable(Knapsack knapsack, List<Item> items){
        Collections.sort(items, new ValueComparator());
        while(items.size() > 0){
            Item item = items.remove(0);
            knapsack.pack(item);
        }
    }


    public static void main(String[] args) {
        // double due = 10.37;
        // double paid = 20.00;
        // System.out.println("Amount due: " + due + " paid: " + paid
        // + " change due: " + makeChange(due, paid));

        Knapsack knapsack = new Knapsack(10);

        System.out.println("\nSPORTS SET");
        packItems(knapsack,ItemSets.sportsSet());
        System.out.println("lightest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack,ItemSets.sportsSet());
        System.out.println("most valuable: " + knapsack);
        knapsack.empty();

        System.out.println("\nELECTRONICS SET");
        packItems(knapsack,ItemSets.electronicsSet());
        System.out.println("lightest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack,ItemSets.electronicsSet());
        System.out.println("most valuable: " + knapsack);
        knapsack.empty();

        System.out.println("\nTOY SET");
        packItems(knapsack,ItemSets.toySet());
        System.out.println("lightest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack,ItemSets.toySet());
        System.out.println("most valuable: " + knapsack);
        knapsack.empty();

        System.out.println("\nMETAL SET");
        packItems(knapsack,ItemSets.metalSet());
        System.out.println("lightest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack,ItemSets.metalSet());
        System.out.println("most valuable: " + knapsack);
        knapsack.empty();

        System.out.println();

    }
}
