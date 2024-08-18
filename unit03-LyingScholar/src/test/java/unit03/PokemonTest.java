package unit03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unit03.practicum.PokemonType;
import unit03.practicum.pokemon;

class PokemonTest {

    @Test
    void testChangeName() {
        
        pokemon pikachu = new pokemon("Pikachu", PokemonType.FIRE, 5);
        
        
        pikachu.changeName("Raichu");

        assertEquals("Raichu", pikachu.getName());
    }

    @Test
    void testLevelUp() {
        pokemon charmander = new pokemon("Charmander", PokemonType.FIRE, 15);
        charmander.levelUp();
        assertEquals(16, charmander.getLevel());
    }

    @Test
    void testToString() {
        pokemon bulbasaur = new pokemon("Bulbasaur", PokemonType.GRASS, 3);
        assertEquals("Pokemon{name=Bulbasaur, type=GRASS, level=3}", bulbasaur.toString());
    }

    @Test
    void testEqualsWithEqualObjects() {
        pokemon pikachu1 = new pokemon("Pikachu", PokemonType.FIRE, 5);
        pokemon pikachu2 = new pokemon("Pikachu", PokemonType.FIRE, 5);
        assertTrue(pikachu1.equals(pikachu2), "Two Pokémon with the same name, type, and level should be equal");
    }

    @Test
    void testEqualsWithDifferentObjects() {
        pokemon pikachu = new pokemon("Pikachu", PokemonType.ELECTRIC, 5);
        pokemon charmander = new pokemon("Charmander", PokemonType.FIRE, 5);
        assertFalse(pikachu.equals(charmander), "Two Pokémon with different names or types should not be equal");
    }

    @Test
    void testEqualsWithNull() {
        pokemon pikachu = new pokemon("Pikachu", PokemonType.ELECTRIC, 5);
        assertFalse(pikachu.equals(null), "A Pokémon should not be equal to null");
    }

    @Test
    void testEqualsWithDifferentClass() {
        pokemon pikachu = new pokemon("Pikachu", PokemonType.ELECTRIC, 5);
        String notAPokemon = "Not a Pokemon";
        assertFalse(pikachu.equals(notAPokemon), "A Pokémon should not be equal to an object of a different class");
    }
}