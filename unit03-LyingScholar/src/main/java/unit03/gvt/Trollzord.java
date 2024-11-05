package unit03.gvt;


public class Trollzord extends Troll {
    public static final int MAX_HP = 64;
    public static final double REGEN_AMOUNT = 0.05;
    
    
    public Trollzord(){
        super("Trollzord", MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Flame War", hits, DamageType.MAGICAL);
    }
    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        if(attack.getDamageType()==DamageType.HOLY){
            adjustment = 1.25;
        }

        int[] hits = attack.getHits();
        for (int hit : hits){
            int amount = (int)(hit*adjustment);
            deductHP(amount);
        }
    }


    @Override
    public void regenerate() {
        if(!isVanquished()){
            currentHP += (int)(MAX_HP* REGEN_AMOUNT);
            currentHP = currentHP >= MAX_HP ? MAX_HP : currentHP;
        }
    }

}
