package unit03.practicum;

public class pokemon {
    public String name;
    private PokemonType pokemonType;
    private int level;

    public pokemon(String name, PokemonType pokemonType, int level){
        this.name = name;
        this.pokemonType = pokemonType;
        this.level = level;
        
    }

    public pokemon(String name, PokemonType pokemonType){
        this.name = name;
        this.pokemonType = pokemonType;
        this.level = 1;
}

    public String getName(){
        return name;
    }

    public PokemonType getPokemonType(){
        return pokemonType;
    }

    public int getLevel(){
        return level;
    }
    public void changeName(String newName){
        this.name = newName;
    }

    public void levelUp(){
        if (this.level < 100){
            this.level++;
        }else{
            System.out.println("max level reached");;
        }
    }
    //2//11
    @Override
    public String toString(){
        return "Pokemon{name=" + name + ", type=" + pokemonType +
        ", level=" + level + "}";
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof pokemon){
            pokemon other = (pokemon)obj;
            return pokemonType.equals(other.pokemonType)&&
                (level == other.level);
        }else{
            return false;
        }
    }
}

