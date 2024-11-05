package practicum1.easter;

import java.util.Scanner;

public class EasterDate {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Plese enter the year: ");
        int year = scanner.nextInt();
        
        Easter easter = new Easter(year);
        
        System.out.println("Month:  " + easter.getEasterMonth());
        System.out.println("Day: " + easter.getEasterDay());



        scanner.close();
    }
}