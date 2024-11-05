package unit03.gvt;

public class Thief extends Goat{
    public static final int MAX_HP = 100;

    public Thief(String name){
        super(name,MAX_HP);
    }
    
    @Override
    public String toString(){
        return "A thief name " + super.getName() + " with " + super.getCurrentHP() +
        "/" + MAX_HP + " hitpoints!";
    }

    @Override
    public Attack attack(){
        int[] hits = {5,10,20};
        return new Attack("Hidden Dagger", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack){
        double adjustment = 1.0;
        DamageType damageType = attack.getDamageType();
        if(damageType == DamageType.PHYSICAL){
            adjustment = 1.25;
        }else if(damageType == DamageType.HOLY){
            adjustment = 0.75;
        }

        for(int hit : attack.getHits()){
            currentHP -= (hit * adjustment);
        }
        currentHP = currentHP > 0 ? currentHP : 0;

    }

    public static void main(String[] args){
        //3/4
        System.out.println();
        Thief lifty = new Thief("Lifty Moore");
        System.out.println(lifty);
        Thief fingers = new Thief("Fingers O' Hare");
        System.out.println(fingers);


        //3/5
        System.out.println();
        Attack liftyAttack = lifty.attack();
        fingers.takeDamage(liftyAttack);
        System.out.println(lifty);
        System.out.println(fingers);
        System.out.println();
        Attack fingersAttack = fingers.attack();
        lifty.takeDamage(fingersAttack);
        System.out.println(lifty);
        System.out.println(fingers);


        System.out.println();

        
    }
}

