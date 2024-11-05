package unit10.practicum;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .filter(value -> value % 3 == 0 && value % 5 == 0)
                .forEach(value -> System.out.println("FizzBuzz: " + value));
    }
}
