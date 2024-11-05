package unit01;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class PrimesTest {

    @Test
    void testIsPrimeWithPrimalNomber() {
        assertTrue(Primes.isPrime(5), "5 should be prime");
    }
    @Test
    void testIsPrimeWithZeror() {
        assertFalse(Primes.isPrime(0), "0 should not be prime");
    }

    @Test
    void testIsPrimeWithNegativeNomber() {
        assertFalse(Primes.isPrime(-3), "-3 should not be prime");
    }
    @Test
    public void testIsPrimeWizBigNomber() {
        assertFalse(Primes.isPrime(7920), "7920 should not be prime");
    }
}
