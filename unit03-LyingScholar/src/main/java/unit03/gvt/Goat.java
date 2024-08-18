package unit03.gvt;
//3/10
public abstract class Goat {
    private final String name;
    private final int maximumHP;

    //3/11
    protected int currentHP;

    public Goat(String name, int maximumHP){
        this.name = name;
        this.maximumHP = maximumHP;
        currentHP = maximumHP;
    }

    @Override
    public String toString(){
        return "A goat name " + name + " with " + currentHP +
        "/" + maximumHP + " hitpoints!";
    }

    public String getName(){
        return name;

    }

    public int getCurrentHP(){
        return currentHP;
    }

    public void heal(int amount){
        currentHP += amount;
        // if(currentHP > maximumHP){
        //     currentHP = maximumHP;
        // }

        currentHP = currentHP < maximumHP ? currentHP : maximumHP;
        // boolean ? do this : else do this
        //turnery operation or somthn
        
    }

    public boolean isConscious(){
        return currentHP > 0;
    }

    //3/5
    public abstract Attack attack();

    //3/5
    public abstract void takeDamage(Attack attack);

}
