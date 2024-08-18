package unit01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SieveValidator {

    public static int[] readSieve(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int size = Integer.parseInt(line);
            int[] sieve = new int[size];

            int index = 0;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    sieve[index++] = c - '0';
                }
            }
            return sieve;
        } catch (IOException | NumberFormatException e) {
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
            }
        }
    }

    public static int repairSieve(int[] sieve) {
        if (sieve == null) {
            System.out.println("The sieve array is null.");
            return 0;
        }

        int errors = 0;
        System.out.println("Validating a sieve of size " + sieve.length + "…");
        for (int n = 0; n < sieve.length; n++) {
            boolean isPrime = Primes.isPrime(n);
            boolean markedAsPrime = sieve[n] == 0;

            if (isPrime != markedAsPrime) {
                sieve[n] = isPrime ? 0 : 1;
                System.out.println(n + " is incorrectly marked as " + (markedAsPrime ? "NOT prime." : "prime."));
                errors++;
            }
        }
        return errors;
    }
}