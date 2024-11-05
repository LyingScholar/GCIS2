package unit04.practicum;


public class SSBBattle {
    private Fighter fighter1;
    private Fighter fighter2;

    public SSBBattle(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    
    public void fightRound() {
        if (!fighter1.isUnconscious() && !fighter2.isUnconscious()) {
            int damageToFighter1 = fighter2.getAttackDamage();
            int damageToFighter2 = fighter1.getAttackDamage();

            fighter1.receiveDamage(damageToFighter1);
            fighter2.receiveDamage(damageToFighter2);
        }
    }


    public void announceWinner() {
        if (fighter1.isUnconscious() && fighter2.isUnconscious()) {
            System.out.println("It's a draw!");
        } else if (fighter1.isUnconscious()) {
            System.out.println(fighter2.getName() + " wins!");
        } else if (fighter2.isUnconscious()) {
            System.out.println(fighter1.getName() + " wins!");
        }
    }

    
    public static void main(String[] args) {
        Manio manio = new Manio("Manio", 100, 25, 50, 25);
        Lonk lonk = new Lonk("Lonk.", 150, 45, 0.5);

        SSBBattle arena = new SSBBattle(manio, lonk);

        do {
            arena.fightRound();
            arena.announceWinner();
        } while (!manio.isUnconscious() && !lonk.isUnconscious());
    }
}
 