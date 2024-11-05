package unit11.activities;

public class Waiter implements Runnable {
    private final Object lock;

    public Waiter(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        synchronized(lock){
            try{
                lock.wait();
            } catch(InterruptedException ie){}
                System.out.println("done waiting!");
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        for(int i = 0; i<10;i++){
            Waiter waiter = new Waiter(lock);
            Thread thread = new Thread(waiter);
            thread.start();
        }
            try{
            Thread.sleep(1);
        }catch(InterruptedException ie){}
        
        synchronized(lock){
            lock.notifyAll();
        }
        System.out.println("Thread started...");
    }
}
