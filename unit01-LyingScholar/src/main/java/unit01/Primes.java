package unit01;

import java.util.Scanner;

public class Primes {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a natural number : ");
            number = scanner.nextInt();
            if (number < 1) {
                break;
            }
            System.out.println("Number " + number + " is prime: " + isPrime(number));
        }
        scanner.close();
    }
}