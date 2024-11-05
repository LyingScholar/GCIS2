package practicum2.populous;

public class Country implements Comparable<Country>{
    private final String name;
    private final long population;

    public Country(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public String toString(){
        return name +": population = " + population;
    }

    @Override
    public int compareTo(Country other) {
        return Long.compare(this.getPopulation(), other.getPopulation());
    }
    
}
