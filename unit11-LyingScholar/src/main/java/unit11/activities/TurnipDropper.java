package unit11.activities;
import java.util.Random;
import unit11.ggg.Trough;

public class TurnipDropper implements Runnable {
    private Trough trough;
    public TurnipDropper(Trough trough) {
        this.trough = trough;

    }

    @Override
    public void run(){
        System.out.println("The turnip dropper starts dropping turnips!");
        while (!trough.atLimit()) {
            try{
                Thread.sleep(5);
            }catch(InterruptedException ie){}
            int numTurnips = generateTurnipCount();
            synchronized(trough){
                for (int i = 0; i < numTurnips; i++) {
                    trough.drop();
                    }
                System.out.println("The dropper drops "+numTurnips+" turnips into the trough!");
                trough.notifyAll();
            }
                
        }
    }

    private int generateTurnipCount() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
}