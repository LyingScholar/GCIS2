package unit10.Concurrency;

public class CounterThread extends Thread{
    private final String name;

    public CounterThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i =1;i<=100;i++){
            System.out.println(name + ": " +i);
        }
    }
    public static void main(String[] args) {
        System.out.println();
        Thread counter = new CounterThread("Counter");
        counter.start();
        
        int count = 0;

        while (counter.isAlive()) {
            try{
                Thread.sleep(50);
            }catch(InterruptedException ie){}
            count++;
        }
        for(char ch ='A'; ch <= 'Z';ch++){
            System.out.print(ch + " ");
        }
        System.out.println();
        System.out.println(count);
        // counter.start();

        System.out.println();
    }
}
