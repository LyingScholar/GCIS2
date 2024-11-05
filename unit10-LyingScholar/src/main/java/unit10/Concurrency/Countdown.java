package unit10.Concurrency;

public class Countdown implements Runnable{

    @Override
    public void run() {

        int i = -10;
        String header = "T";
        try{
            while (true) {
                if(i==0){
                    System.out.println("Liftoff!");
                    header = "T+";
                }else{
                    System.out.println(header + (Math.pow(i,5)));
                }
                Thread.sleep(0);
                i++;
            }
        }catch(InterruptedException ie){}
    }
    
    public static void main(String[] args) {
        new Thread(new Countdown()).start();
    }
}
