package unit03.gvt;

//3/11
public class Mage extends Goat{
    
    // //3/4
    public static final int MAX_HP = 125;
    
    // private final String name;
    // private final int maximumHP;
    // private int currentHP;

    public Mage(String name){
        super(name, MAX_HP);
    }

    // public String getName(){
    //     return name;

    @Override
    public String toString(){
        return "A mage name " + super.getName() + " with " + super.getCurrentHP() +
        "/" + MAX_HP + " hitpoints!";
    }

    //3/5
    @Override
    public Attack attack(){
        int[] hits = {9,9,9,9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
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
        Mage hairy = new Mage("Hairy Potter");
        System.out.println(hairy);
        Mage rufus = new Mage("Rufus McHoof");
        System.out.println(rufus);


        //3/5
        System.out.println();
        Attack hairyAttack = hairy.attack();
        rufus.takeDamage(hairyAttack);
        System.out.println(hairy);
        System.out.println(rufus);
        System.out.println();
        Attack rufusAttack = rufus.attack();
        hairy.takeDamage(rufusAttack);
        System.out.println(hairy);
        System.out.println(rufus);
        
        System.out.println();
    }
}
