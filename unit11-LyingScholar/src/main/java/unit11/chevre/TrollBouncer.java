package unit11.chevre;

public class TrollBouncer  implements Runnable{
    private final ClubChevre club;

    public TrollBouncer(ClubChevre club){
        this.club = club;
    }
    @Override
    public void run() {
        synchronized(club){
            //if there is room in the club and goats ar ein line...
            while(!club.isAtCapacity() && club.numberOfGoatsInLine()>0){

            
            //choose thr next goat
            Goat goat = chooseGoat();
            //remove it fromt he line
            club.removeGoatFromLine(goat);
            //escort to the dance floor
            club.startDancing(goat);
            System.out.println("The TrollBouncer lets "+ goat.getName()+" into the club. Now there are "
            + club.numberOfDancingGoats() + " goats on the dance floor.");
            synchronized(goat){
                goat.notify();
            }
            }
            //the club is full or the line is empty, sop wait foir another goat
            //to get in line or exit the club
            try{
                club.wait();
            }catch(InterruptedException ie){}
        }
    }

    private Goat chooseGoat(){
        return club.getGoatAtPosition(0);
    }
}
