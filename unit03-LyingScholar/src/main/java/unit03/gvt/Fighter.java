package unit03.gvt;

public class Fighter extends Goat {
    
    public static final int MAX_HP = 125;

    public Fighter(String name){
        super(name, MAX_HP);
    }

    @Override
    public String toString(){
        return "A fighter name " + super.getName() + " with " + super.getCurrentHP() +
        "/" + MAX_HP + " hitpoints!";
    }

    @Override
    public Attack attack(){
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack){
        double adjustment = 1.0;
        DamageType damageType = attack.getDamageType();
        if(damageType == DamageType.PHYSICAL){
            adjustment = 0.75;
        }else if(damageType == DamageType.MAGICAL){
            adjustment = 1.25;
        }

        for(int hit : attack.getHits()){
            currentHP -= (hit * adjustment);
        }
        currentHP = currentHP > 0 ? currentHP : 0;

    }

    public static void main(String[] args){
        //3/4
        System.out.println();
        Fighter bobby = new Fighter("Bobby O'Bleater");
        System.out.println(bobby);
        Fighter scruffy = new Fighter("Scruffy Snyder");
        System.out.println(scruffy);


        //3/5
        System.out.println();
        Attack bobbyAttack = bobby.attack();
        scruffy.takeDamage(bobbyAttack);
        System.out.println(bobby);
        System.out.println(scruffy);
        System.out.println();
        Attack scruffyAttack = scruffy.attack();
        bobby.takeDamage(scruffyAttack);
        System.out.println(bobby);
        System.out.println(scruffy);


        System.out.println();

        
    }
}
