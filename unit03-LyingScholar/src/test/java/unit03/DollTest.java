package unit03;

import org.junit.jupiter.api.Test;

import toys.Doll;

public class DollTest {

    @Test
    public void testPullString() {
        String[] dollSayings = {"Hello!", "I'm a Doll!", "Let's play!"};
        Doll doll = new Doll("4567890", 14.99, "Blonde", "Blue", dollSayings);
        doll.pullString();
        // Validate that the correct saying is retrieved
        
        // Additional test cases can be added based on expected behavior.
    }
}