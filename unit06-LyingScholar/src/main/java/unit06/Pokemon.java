package unit06;

import java.util.Collections;
import java.util.LinkedList;

public class Pokemon implements Comparable<Pokemon> {
    private int number;
    private String name;

    public Pokemon(int number, String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    @Override
    public int compareTo(Pokemon o){
        return this.number-o.number;
    }

    public static void main(String[] args) {
        LinkedList<Pokemon> pokelist = new LinkedList<>();
        pokelist.add(new Pokemon(7, "Squirtle"));
        pokelist.add(new Pokemon(54, "Psyduck"));
        pokelist.add(new Pokemon(4, "Charmander"));
        System.out.println("\n" + pokelist);

        Collections.sort(pokelist);
        System.out.println("\n" + pokelist);

        System.out.println();
    }
}
