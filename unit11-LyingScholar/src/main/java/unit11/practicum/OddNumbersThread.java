package unit11.practicum;

public class OddNumbersThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 99; i += 2) {
            System.out.println(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }
    }
}