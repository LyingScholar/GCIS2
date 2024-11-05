package unit10.Concurrency;

import java.util.Scanner;

public class Counters{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter number of counters:");
        int num = scan.nextInt();
        scan.close();

        Thread[] counters = new Thread[num];

        for(int i = 1;i<num;i++){
            Runnable counter = new RunnableCounter("Counter"+ i);
            // Thread counterThread = new Thread(counter);
            // counterThread.start();
            counters[i] = new Thread(counter);
            counters[i].start();
            // try{
            //     counterThread.join();
            // }catch(InterruptedException ie){}
        }
        for(int i=0;i<num;i++){
            try{
                counters[i].join();
            }catch(InterruptedException ie){}

        }
        System.out.println("Counting all done!");
        System.out.println();
    }
}
