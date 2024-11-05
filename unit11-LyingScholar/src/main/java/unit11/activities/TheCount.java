package unit11.activities;

public class TheCount implements Runnable {

    public static int[] COUNT = new int[1];

    private final int id;

    public TheCount(int id){
        this.id = id;
    }
    @Override
    public void run() {
        // synchronized(COUNT){
            System.out.println("Counter" +id+" is starting...");
            for(int i =0;i<100000;i++){
                synchronized(COUNT){
                    COUNT[0]++;
                }
            }
            System.out.println("Counter "+id+" is done!");
        // }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            TheCount counter = new TheCount(1);
            Thread thread = new Thread(counter);
            thread.start();
        }

        try{
            Thread.sleep(1000);
            System.out.println(COUNT[0]);

        }catch(InterruptedException ie){}
    }
    
}
