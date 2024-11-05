package unit11.practicum;

class NumberPrint implements Runnable {
    private int number;

    public NumberPrint(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println(number);
    }

    
}
