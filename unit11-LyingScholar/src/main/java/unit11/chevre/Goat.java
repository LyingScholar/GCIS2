package unit11.chevre;

/**
 * A class that will ultimately represent a party Goat out for a night of
 * dancing at the world famous Club Chèvre.
 */
public class Goat implements Runnable{
    private static final int MIN_COOLNESS = 1;

    private static final int MAX_COOLNESS = 100;
    private static final int MIN_STAMINA = 5;
    private static final int MAX_STAMINA = 10;

    private final String name;
    private final int coolness;
    private final int stamina;
    private final ClubChevre club;

    public Goat(ClubChevre club){
        this.club = club;
        this.name = Utils.makeGoatName();
        coolness = Utils.getRandomNumber(MIN_COOLNESS, MAX_COOLNESS);
        stamina = Utils.getRandomNumber(MIN_STAMINA, MAX_STAMINA);
    }

    public String getName(){
        return name;
    }

    public int getStamina(){
        return stamina;
    }

    public int getCoolness(){
        return coolness;
    }


    @Override
    public void run() {
        synchronized(club){
        System.out.println(name + " gets in line behind "+ club.numberOfGoatsInLine() + " other goats.");
        club.getInLine(this);
        club.notify();
    }

        synchronized(this){
            try{
                this.wait();
            }catch(InterruptedException ie){}
        }
        System.out.println(name + " is escorted into the club.");
        
    }


    public static void main(String[] args) {
        System.out.println();

        ClubChevre club = new ClubChevre();

        Goat goat = new Goat(club);
        Thread thread = new Thread(goat);
        thread.start();

        // try{
        //     Thread.sleep(2000);
        // }catch(InterruptedException ie){}
    }


}
