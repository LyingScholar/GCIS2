package unit11.practicum;

public class EvensAndOdds {

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddNumbersThread());
        Thread evenThread = new Thread(new EvenNumbersThread());


        oddThread.start();
        evenThread.start();
    }
}
