package unit03.gvt;


public abstract class Troll {
    private final String name;
    private final int maxHP;
    protected int currentHP;
    private final double regenAmount;

    public Troll(String name, int maxHP, double regenAmount) {
        this.name = name;
        this.maxHP = maxHP;
        currentHP = maxHP;
        this.regenAmount = regenAmount;

    }

    public String getName(){
        return name;

    }

    public int getCurrentHP(){
        return currentHP;
    }
    public int getmaxHP(){
        return maxHP;


    }

    public double getRegenAmount(){
        return regenAmount;
    }

    public boolean isVanquished(){
        return currentHP<=0;
    }
    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    public abstract void regenerate();

    protected void deductHP(int amount){
        currentHP -= amount;
        currentHP = currentHP < 0 ? 0 : currentHP;
        }


}
