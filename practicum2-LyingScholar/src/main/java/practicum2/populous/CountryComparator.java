package practicum2.populous;

import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2) {
        return Long.compare(c2.getPopulation(), c1.getPopulation());
    }
}