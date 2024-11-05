package unit04.practicum;

public class Lonk extends Fighter {
    private int swordDamage;
    private double blockChance;

    public Lonk(String name, int health, int swordDamage, double blockChance) {
        super(name, health, 0);
        this.swordDamage = swordDamage;
        this.blockChance = blockChance;
    }

    @Override
    public int getAttackDamage() {
        System.out.println(this.getName() + " attacks with a sword for " + swordDamage + " damage.");
        return swordDamage;
    }

    @Override
    public void receiveDamage(int damage) {
        if (Math.random() < blockChance) {
            int blockedDamage = (int) (damage / 2);
            System.out.println(this.getName() + " blocked the incoming attack and takes " + blockedDamage + " damage.");
            super.receiveDamage(blockedDamage);
        } else {
            System.out.println(this.getName() + " takes " + damage + " damage.");
            super.receiveDamage(damage);
        }
    }
}