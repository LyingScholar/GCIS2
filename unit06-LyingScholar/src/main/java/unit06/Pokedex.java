package unit06;

public class Pokedex implements BinarySearchTree<Pokemon> {
    private BinarySearchTree<Pokemon> bst;
    // private int size;

    public Pokedex(){
        bst = new NodeBST<>();
    }

    public boolean containsPokemon(Pokemon poke){
        return bst.search(poke);
    }

    public void addPokemon(Pokemon poke){
        if(!containsPokemon(poke)){
        bst.insert(poke);
        }
    }

    @Override
    public String toString(){
        return bst.toString();
    }

    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        // pokedex.addPokemon(39);
        // pokedex.addPokemon(93);
        // pokedex.addPokemon(51);
        // pokedex.addPokemon(25);
        // pokedex.addPokemon(173);
        // pokedex.addPokemon(135);
        // pokedex.addPokemon(64);
        // pokedex.addPokemon(143);
        // pokedex.addPokemon(76);
        // pokedex.addPokemon(19);
        // pokedex.addPokemon(26);
        // pokedex.addPokemon(3);
        // pokedex.addPokemon(52);
        // pokedex.addPokemon(2);
        // pokedex.addPokemon(148);

        // System.out.println("\n" + pokedex);
        // System.out.println();

        // System.out.println(64 + ": " + pokedex.containsPokemon(64));
        // System.out.println(65 + ": " + pokedex.containsPokemon(65));
        // System.out.println(50 + ": " + pokedex.containsPokemon(50));
        // System.out.println(51 + ": " + pokedex.containsPokemon(51));
        // System.out.println(53 + ": " + pokedex.containsPokemon(53));

        pokedex.addPokemon(new Pokemon(39, "Jigglypuff"));
        pokedex.addPokemon(new Pokemon(93, "Haunter"));
        pokedex.addPokemon(new Pokemon(51, "Dugtrio"));
        pokedex.addPokemon(new Pokemon(64, "Kadabra"));
        pokedex.addPokemon(new Pokemon(25, "Pikachu"));
        pokedex.addPokemon(new Pokemon(173, "Cleffa"));

        System.out.println("\n" + pokedex);
        System.out.println();

        System.out.println(new Pokemon(64, "Kadabra") + ": " + pokedex.containsPokemon(new Pokemon(64, "Kadabra")));
        System.out.println(new Pokemon(25, "Pikachu") + ": " + pokedex.containsPokemon(new Pokemon(25, "Pikachu")));
        System.out.println(new Pokemon(50, "Diglett") + ": " + pokedex.containsPokemon(new Pokemon(50, "Diglett")));
        System.out.println();
    }

    @Override
    public void insert(Pokemon value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean search(Pokemon target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
}
