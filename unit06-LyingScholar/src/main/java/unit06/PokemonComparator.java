package unit06;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PokemonComparator implements Comparator<Pokemon>{

    @Override
    public int compare(Pokemon o1, Pokemon o2){
        String o1Name = o1.getName().toLowerCase();
        String o2Name = o2.getName().toLowerCase();

        return o1Name.compareTo(o2Name);
    }
    public static void main(String[] args) {
        LinkedList<Pokemon> pokelist = new LinkedList<>();
        pokelist.add(new Pokemon(7, "Squirtle"));
        pokelist.add(new Pokemon(54, "Psyduck"));
        pokelist.add(new Pokemon(4, "Charmander"));
        System.out.println("\n" + pokelist);

        Collections.sort(pokelist);
        System.out.println("\n" + pokelist);

        
        Collections.sort(pokelist, new PokemonComparator());
        System.out.println("\n" + pokelist);

        System.out.println();
    }
}
