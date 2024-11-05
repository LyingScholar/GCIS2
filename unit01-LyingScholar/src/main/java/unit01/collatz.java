package unit01;

import java.util.Scanner;

public class collatz {
    public static String sequence(int n) {
        if (n < 1) {
            return "";
        }
        
        StringBuilder sequence = new StringBuilder();
        while (n != 1) {
            sequence.append(n).append(" ");
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        sequence.append(1);
        return sequence.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Enter a natural number :");
            number = scanner.nextInt();
            if (number < 1) {
                break;
            }



            System.out.println("Collatz Sequence starting with " + number + ": " + sequence(number));
        }
        scanner.close();
    }
}
