package unit11.activities;
import unit11.ggg.Trough;

public class GreedyGreedyGoats {


    public static void main(String[] args) {
        Trough trough = new Trough(25);

        TurnipDropper turnipDropper = new TurnipDropper(trough);
        Thread turnipDropperThread = new Thread(turnipDropper);

        Goat[] goats = new Goat[]{
            new Goat(TextColor.CYAN, trough),
            new Goat(TextColor.BLUE, trough),
            new Goat(TextColor.PURPLE, trough),
            new Goat(TextColor.RED, trough)
        };

        Thread[] goatThreads = new Thread[goats.length];

        for (int i = 0; i < goats.length; i++) {
            goatThreads[i] = new Thread(goats[i]);
            goatThreads[i].start();
        }
            turnipDropperThread.start();

        synchronized(trough){

        System.out.println(trough.getTurnipsSoFar());
        if (trough.atLimit()){
            System.out.println("Total number of turnips dropped: " + trough.getTurnipsSoFar());
            int totalTurnipsEaten = 0;
            for(Goat a : goats){
                totalTurnipsEaten += a.getTurnipsEaten();
            }
                
            System.out.println("Total number of turnips eaten by all goats: " + totalTurnipsEaten);
        }
        trough.notifyAll();
    }
    }
}

            // trough.notifyAll();
        // Arrays.sort(goats, Comparator.comparingInt(Goat::getTurnipsEaten).reversed());
        // System.out.println("Goats sorted by turnips eaten (most to least):");
        // Arrays.sort(goats, Comparator.comparingInt(Goat::getTurnipsEaten).reversed());
        // for (Goat goat : goats) {
        //     System.out.println(goat + " ate " + goat.getTurnipsEaten() + " turnips.");
        // }

        // try{
        //     Thread.sleep(1);
        // }catch(InterruptedException ie){}