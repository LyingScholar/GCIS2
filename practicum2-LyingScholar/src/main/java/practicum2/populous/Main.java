package practicum2.populous;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> world = new LinkedList<>();
        world.add(new Country("Nigeria    ", 223804632));
        world.add(new Country("Colombia   ", 52085168));
        world.add(new Country("Pakistan   ", 240485658));
        world.add(new Country("Slovenia   ", 2119675));
        world.add(new Country("Netherlands", 17618299));
        world.add(new Country("Lithuania  ", 2718352));
        world.add(new Country("Ghana      ", 34121985));
        world.add(new Country("Brazil     ", 216422446));
        world.add(new Country("Finland    ", 5545475));
        world.add(new Country("Paraguay   ", 6861524));
   
        System.out.println();
        System.out.println("Countries in insertion order:");
        System.out.println();
        for(Country country : world) {
            System.out.println(country);
        }

        // Comparable sort - uncomment the block below when
        // working on the second task.

        System.out.println();
        System.out.println("Comparable sort by name ascending:\n");
        Collections.sort(world);
        for(Country country : world) {
            System.out.println(country);
        }

        // Comparator sort - uncomment the block below when 
        // working on the third task.
    
        System.out.println();
        System.out.println("Comparator sort by population descending:\n");
        Collections.sort(world, new CountryComparator());
        for(Country country : world) {
            System.out.println(country);
        }
    
        System.out.println();
    }
}
