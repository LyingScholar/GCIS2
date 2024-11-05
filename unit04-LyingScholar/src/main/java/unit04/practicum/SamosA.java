package unit04.practicum;

public class SamosA extends Fighter {
    private int smallAttackDamage;
    private int largeAttackDamage;
    private int largeAttackChance;

    public SamosA(String name, int health, int smallAttackDamage, int largeAttackDamage, int largeAttackChance) {
        super(name, health, 0);
        this.smallAttackDamage = smallAttackDamage;
        this.largeAttackDamage = largeAttackDamage;
        this.largeAttackChance = largeAttackChance;
    }

    @Override
    public int getAttackDamage() {
        int chance = (int) (Math.random() * (100));
        if (chance < 25) {
            System.out.println(this.getName() + "uses missiles for " + largeAttackDamage + " damage.");
            return largeAttackChance;
        } else {
            System.out.println(this.getName() + "uses arm cannon for " + smallAttackDamage + " damage.");
            return smallAttackDamage;
        }
    }

    @Override
    public void receiveDamage(int damage) {
        System.out.println(this.getName() + " takes " + damage + " damage.");
        super.receiveDamage(damage);
    }
}