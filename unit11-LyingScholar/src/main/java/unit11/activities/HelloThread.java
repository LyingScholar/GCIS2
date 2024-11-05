package unit11.activities;

import java.util.ArrayList;
import java.util.List;

public class HelloThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for(int i =0;i<5;i++){
            HelloThread hello = new HelloThread();
            Thread thread = new Thread(hello);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread: threads){
            try{
                thread.join();
            }catch(InterruptedException ie){}
        }
    System.out.println("Goodbye!");
    }
    
}
