package unit05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unit05.Iterators.IterableFibonacci;

public class FibonnaciTest {
        private IterableFibonacci iterableFibonacci;

    @BeforeEach
    void setup() {
        iterableFibonacci = new IterableFibonacci(0, 1);
    }

    @Test//worx
    void AddingTheNextFibonacciNumber() {
        iterableFibonacci.add(); // sequence is now 0, 1, 1
        assertEquals(1, iterableFibonacci.get(2), "fib(3) == 1");
    }

    @Test//worx
    void StringRepresentationCheck() {
        iterableFibonacci.add();
        iterableFibonacci.add();
        assertEquals("[0, 1, 1, 2]", iterableFibonacci.toString(), "String ain't stringing");
    }

    @Test//worx
    void FibonacciNumbersCheck() {
        iterableFibonacci.add();
        iterableFibonacci.add();
        iterableFibonacci.add();

        assertEquals(2, iterableFibonacci.get(3), "");
    }

    @Test
    void IndexOutOfBoundsException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> iterableFibonacci.get(10));
        assertTrue(exception.getMessage().contains("Index: 10, Size: 2"));
    }

    @Test
    void SequenceLengthCheck() {
        assertEquals(2, iterableFibonacci.length(), "Initial sequence should have length 2");
        iterableFibonacci.add();
        assertEquals(3, iterableFibonacci.length(), "len gotta be 3");
    }

    @Test
    void iterator_ShouldIterateCorrectly() {

        iterableFibonacci = new IterableFibonacci(1, 1);
        iterableFibonacci.add();
        iterableFibonacci.add();
        iterableFibonacci.add();
        // iterableFibonacci.add();
        // iterableFibonacci.add();
        //1, 1, 2, 3, 5

        int count = 0;
        long[] expected = {1, 1, 2, 3, 5};
        for (long fibNumber : iterableFibonacci) {
            assertEquals(expected[count], fibNumber, "Fibonacci number did not match at index " + count);
            count++;
        }

        assertEquals(expected.length, count, "Iterator didnt iterate over entire sequence");
    }

}
