package unit12.practicum;

public class EvensAndOdds {

    private final Object lock = new Object();
    private volatile boolean oddTurn = true;

    public class OddNumbersPrinter implements Runnable {
        public void run() {
            for (int i = 1; i < 100; i += 2) {
                synchronized (lock) {
                    while (!oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ie) {


                            return;
                        }
                    }
                    System.out.println(i);
                    // System.out.println("odd");
                    oddTurn = false;

                    lock.notify();
                }
            }
        }
    }

    public class EvenNumbersPrinter implements Runnable {
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                synchronized (lock) {
                    while (oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException ie) {
                            return;

                        }
                    }
                    // System.out.println("Even");
                    System.out.println(i);
                    oddTurn = true;

                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        EvensAndOdds eventOfEvenandOdd = new EvensAndOdds();
        eventOfEvenandOdd.startThreads();
    }

    public void startThreads() {
        Thread oddsThread = new Thread(new OddNumbersPrinter());
        Thread evensThread = new Thread(new EvenNumbersPrinter());

        oddsThread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException ie) {}
        evensThread.start();
    }
}


