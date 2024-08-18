package unit03.gvt;


//3/7
public class GoatArena {
    public static void battle(Goat goat1, Goat goat2){
        System.out.println();
        System.out.println(goat1.getName() + " and " + goat2.getName() + " enter the arena!");
        int round = 1;

        while(goat1.isConscious() && goat2.isConscious()){
            System.out.println();
            System.out.println("ROUND " + round + "! FIGHT!");
            Attack attack1 = goat1.attack();

            System.out.println(goat1.getName() + " atttacks with " + attack1.getName() + "!");
            goat2.takeDamage(attack1);


            Attack attack2 = goat2.attack();

            System.out.println(goat2.getName() + " atttacks with " + attack2.getName() + "!");
            goat2.takeDamage(attack2);

            System.out.println(("End of round " + round + "!"));
            System.out.println("    " + goat1);
            System.out.println("    " + goat2);
            round++;
    


        }//end while
        System.out.println();
        if(goat1.isConscious()){
            System.out.println(goat1.getName() + " wins!");
        }else if(goat2.isConscious()){
            System.out.println(goat2.getName() + " wins!");
        }else{
            System.out.println("The fight end in a draw");
        }
    }
    public static void battle(Mage goat1, Mage goat2){
        System.out.println();
        System.out.println(goat1.getName() + " and " + goat2.getName() + " enter the arena!");
        int round = 1;

        while(goat1.isConscious() && goat2.isConscious()){
            System.out.println();
            System.out.println("ROUND " + round + "! FIGHT!");
            Attack attack1 = goat1.attack();

            System.out.println(goat1.getName() + " atttacks with " + attack1.getName() + "!");
            goat2.takeDamage(attack1);


            Attack attack2 = goat2.attack();

            System.out.println(goat2.getName() + " atttacks with " + attack2.getName() + "!");
            goat2.takeDamage(attack2);

            System.out.println(("End of round " + round + "!"));
            System.out.println("    " + goat1);
            System.out.println("    " + goat2);
            round++;
    


        }//end while
        System.out.println();
        if(goat1.isConscious()){
            System.out.println(goat1.getName() + " wins!");
        }else if(goat2.isConscious()){
            System.out.println(goat2.getName() + " wins!");
        }else{
            System.out.println("The fight end in a draw");
        }
    }
    public static void battle(Fighter goat1, Fighter goat2){
        System.out.println();
        System.out.println(goat1.getName() + " and " + goat2.getName() + " enter the arena!");
        int round = 1;

        while(goat1.isConscious() && goat2.isConscious()){
            System.out.println();
            System.out.println("ROUND " + round + "! FIGHT!");
            Attack attack1 = goat1.attack();

            System.out.println(goat1.getName() + " atttacks with " + attack1.getName() + "!");
            goat2.takeDamage(attack1);


            Attack attack2 = goat2.attack();

            System.out.println(goat2.getName() + " atttacks with " + attack2.getName() + "!");
            goat2.takeDamage(attack2);

            System.out.println(("End of round " + round + "!"));
            System.out.println("    " + goat1);
            System.out.println("    " + goat2);
            round++;
    


        }//end while
        System.out.println();
        if(goat1.isConscious()){
            System.out.println(goat1.getName() + " wins!");
        }else if(goat2.isConscious()){
            System.out.println(goat2.getName() + " wins!");
        }else{
            System.out.println("The fight end in a draw");
        }
    }

    public static void main(String[] args) {
        //3.7

        Mage mage1 = new Mage("Hairy Potter");
        Fighter fighter1 = new Fighter("Bobby O'Bleader");
        battle(mage1,fighter1);

        Mage mage2 = new Mage("Rufus McHoof");
        // Fighter fighter1 = new Fighter("Bobby O'Bleader");

        mage1.heal(500);
        battle(mage1,mage2);
        System.out.println();

        Fighter fighter2 = new Fighter("Scruffy Snyder");
        fighter1.heal(75);
        battle(fighter1, fighter2);

        System.out.println();

        Goat thief1 = new Thief("Lifty Moore");
        Goat thief2 = new Thief("Fingers O' Hare");
        battle(thief1,thief2);


        System.out.println();
        // Goat goat1 = new Goat("Goaty McHoof",100);
        // Goat goat2 = new Goat("Harvey Hoofter", 1000);
        // battle(goat1,goat2);

    }
}
