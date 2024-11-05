package finalexam.deli;

import java.util.Random;

public class Customer implements Runnable {
    private final char initial;
    private final TicketDispenser ticketDispenser;
    private int ticketNumber;

    public Customer(char initial, TicketDispenser ticketDispenser) {
        this.initial = initial;
        this.ticketDispenser = ticketDispenser;
    }


    @Override
    public void run() {
        ticketNumber = ticketDispenser.getTicket();
        System.out.println("Customer " + initial + " gets ticket " + ticketNumber);

    try {
            Random random = new Random();
            int decidingTime = 100 + random.nextInt(400);
            // Thread.sleep(100 + random.nextInt(400));
            
            System.out.println("Customer " + initial + " is deciding for " + decidingTime + "ms");
            Thread.sleep(decidingTime);
            if (ticketNumber != ticketDispenser.nowServing()) {
                System.out.println("Customer " + initial + " with ticket " + ticketNumber
                + " checks Now Serving, it is " + ticketDispenser.nowServing()
                + "  so they continue to wait");
            }
            ticketDispenser.served();
            System.out.println("Customer " + initial + " with ticket " + ticketNumber + " now being served");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        
    }

    public static void main(String[] args) {
        TicketDispenser ticketDispenser = new TicketDispenser();
        Thread[] customerThreads = new Thread[10];

        for (int i = 0; i < customerThreads.length; i++) {
            //i hope this is allowed
            //i'm just using ASCII values to iterate
                char initial = (char) ('A' + i);
                Customer customer = new Customer(initial, ticketDispenser);
                customerThreads[i] = new Thread(customer);
                customerThreads[i].start();
        }

            for (Thread customerThread : customerThreads) {
                try {
                        customerThread.join();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

        System.out.println("The deli is now closed :)");
    }

}
