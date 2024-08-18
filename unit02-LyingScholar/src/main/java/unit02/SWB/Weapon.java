package unit02.SWB;
//2.2

public class Weapon {
    public String name;
    //2/9 convert Strinfg to enum

    public DamageType damageType;
    public int damageAmount;
    // 2.10 private public String color;


    //2.4
    //2/10
    public Weapon(String name, DamageType damageType, int damageAmount){
        this.name = name;
        this.damageType = damageType;
        this.damageAmount = damageAmount;
        // this.color=color;
    }

    //2/8

    public String getName(){
        return name;
    }

    public int getDamageAmount(){
        return damageAmount;
    }

    public DamageType getDamageType(){
        return damageType;
    }
    //2//11
    @Override
    public String toString(){
        return name + ": damage type " + damageType.getColor() +
        ", damageAmount " + damageAmount;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Weapon){
            Weapon other = (Weapon)obj;
            return (damageAmount == other.damageAmount)&&
                damageType.equals(other.damageType);
        }else{
            return false;
        }
    }



}