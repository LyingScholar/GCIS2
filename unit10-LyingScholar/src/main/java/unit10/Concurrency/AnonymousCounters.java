package unit10.Concurrency;

import java.util.Scanner;

public class AnonymousCounters {
    public static void counter(String name){
        int count = 1;
        while(count<=100){
            System.out.println(name +" : "+ count );
            count++;
        }

    }


    public static void main(String[] args) {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of counters: ");
        int num = scan.nextInt();
        scan.close();

        for(int i = 0;i<num;i++){
            Thread countThread = null;
            String name = "Counter" + i;
            countThread = new Thread(() -> counter(name));
            countThread.start();
        }

        System.out.println();
    }
}
