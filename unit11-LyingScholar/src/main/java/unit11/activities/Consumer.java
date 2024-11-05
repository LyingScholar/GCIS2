package unit11.activities;

import java.util.LinkedList;

public class Consumer implements Runnable{
    private final LinkedList<String> queue;
    private final int id;

    public Consumer(LinkedList<String> queue, int id){
        this.queue= queue;
        this.id =id;
    }

    @Override
    public void run() {
        while (true) {
            String message = null;
            synchronized(queue){
                while (queue.isEmpty()) {
                    try{
                        // System.out.println("Consumer "+ id+": waiting for work...");
                        queue.wait();
                    }catch(InterruptedException ie){}
                }
                message = queue.remove(0);
            }
            System.out.println("Consumer "+ id + ": " + message);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("First Message");
        queue.add("Second Message");

        Consumer consumer = new Consumer(queue, 0);
        Thread thread = new Thread(consumer);
        thread.start();
    }
}
