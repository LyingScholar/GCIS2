package unit11.activities;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable{
    private static final Random RNG = new Random(1);
    private final LinkedList<String> queue;
    private final int id;

    public Producer(LinkedList<String> queue, int id){
        this.queue= queue;
        this.id =id;
    }

    @Override
    public void run() {
        int messageNumber = 1;
        while (true) {

            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){}
            int numberOfMessages = RNG.nextInt(4)+1;
            synchronized(queue){
                for(int n = 0; n<numberOfMessages;n++){
                    String message = "Producer " +id+ " message #" + messageNumber;
                    queue.add(message);
                    messageNumber++;
                }
                queue.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        for(int i = 0; i<5;i++){
        Consumer consumer = new Consumer(queue, i);
        Thread thread = new Thread(consumer);
        thread.start();
        }

        for(int i = 0; i<2;i++){
        Producer producer = new Producer(queue, i);
        Thread thread = new Thread(producer);
        thread.start();
        }
    }
}
