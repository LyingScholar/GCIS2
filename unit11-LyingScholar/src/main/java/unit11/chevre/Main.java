package unit11.chevre;

public class Main {
    public static final int NUM_GOATS= 15;
    public static void main(String[] args) {
        
        System.out.println();

        ClubChevre club = new ClubChevre();
        TrollBouncer troll = new TrollBouncer(club);
        Thread trollThread = new Thread(troll);
        trollThread.start();
        
        for(int i =0;i<NUM_GOATS;i++){
        Goat goat = new Goat(club);
        Thread thread = new Thread(goat);
        thread.start();
        }

        // try{
        //     Thread.sleep(2000);
        // }catch(InterruptedException ie){}
        // this.notifyAll();
        
    }
}
