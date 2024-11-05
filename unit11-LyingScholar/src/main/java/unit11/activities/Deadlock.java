package unit11.activities;

public class Deadlock implements Runnable{
    private final String name;
    private final Object lock1;
    private final Object lock2;

    public Deadlock(String name, Object lock1, Object lock2){
        this.name = name;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println(name + " getting lock on " + lock1);
        synchronized(lock1){
            System.out.println(name + " got lock! Getting  lock on "+ lock2);
            synchronized(lock2){
                System.out.println(name + " got both lock! Releasing "+ lock2);
                
            }
            System.out.println(name + " releasing " + lock1);
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new Deadlock("DL1", lockA, lockB)).start();
        new Thread(new Deadlock("DL2", lockB, lockA)).start();
    }
}
