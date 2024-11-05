package unit06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {
    public static void addAndPrint(Set<String> set){
        set.add("aardvark");
        set.add("Zoo");
        set.add("Monkey");
        set.add("zebra");
        set.add("shark");
        // set.add("Doge");

        for(String item : set){
            System.out.println(item);
        }

    }

    public static void putAndPrint(Map<String,Integer> map) {
        map.put("aardvark",1);
        map.put("Zoo",2);
        map.put("Monkey",3);
        map.put("zebra",4);
        map.put("shark",5);
        
        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static void main(String[] args) {
        System.out.println("\n>>> HashSet");
        addAndPrint(new HashSet<>());

        System.out.println("\n>>> TreeSet");
        addAndPrint(new TreeSet<>());

        System.out.println("\n>>> TreeSet w/Comparator");
        addAndPrint(new TreeSet<>(new AlphabeticComparator()));

        System.out.println("\n>>> HashMap");
        putAndPrint(new HashMap<>());

        System.out.println("\n>>> TreeMap");
        putAndPrint(new TreeMap<>());

        System.out.println("\n>>> TreeMap w/Comparator");
        putAndPrint(new TreeMap<>(new AlphabeticComparator()));

        System.out.println();
    }
}
