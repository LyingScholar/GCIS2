package unit11.practicum;

import java.util.Scanner;

public class SequentialCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            Thread thread = new Thread(new NumberPrint(i));
            thread.start();
            
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        scanner.close();
    }
}
