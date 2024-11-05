package finalexam.deli;

public class TicketDispenser {
    private int nextTicket;
    private int nowServing;

    public TicketDispenser() {
        nextTicket = 1;
        nowServing = 1;
    }

    /**
     * Returns the next available ticket number
     * @return - ticket number
     */
    public int getTicket() {
        int ticket = nextTicket;
        ++nextTicket;
        return ticket;
    }

    /**
     * Returns the ticket number of the customer currently being served
     * @return - ticket number
     */
    public int nowServing() {
        return nowServing;
    }

    /**
     * Called to indicate the current customer is done being served and
     * increments the "now serving" ticket number so that the next customer
     * can be served
     */
    public void served() {
        if (nowServing >= nextTicket)
            throw new IllegalStateException("Now Serving (" + nowServing + ") >= Next Ticket (" + nextTicket + ")");
        
        ++nowServing;
    }
}
