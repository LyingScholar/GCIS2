package unit11.activities;

import unit11.ggg.Trough;

public class Goat implements Runnable {

    private TextColor color;
    private Trough trough;
    private int turnipsEaten;

    public Goat(TextColor color, Trough trough){
        this.color = color;
        this.trough = trough;
        this.turnipsEaten = 0;
    }

    @Override
    public void run() {
        synchronized(trough){
            while (true) {        
                if (trough.eat()) {
                    System.out.println("The " + color+ color.name() +TextColor.DEFAULT+
                    " goat has eaten a turnip!");
                    turnipsEaten++;
                    trough.notifyAll();
                }
                try{
                    System.out.println("The " + color+ color.name() +TextColor.DEFAULT+
                    " goat is waiting for more turnips!");
                    trough.wait();
                }catch(InterruptedException ie){}
            }
        }
    }


    public int getTurnipsEaten() {
        return turnipsEaten;
    }

}