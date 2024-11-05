package unit04.practicum;

public class Manio extends Fighter {
    private int minAttackDamage;
    private int maxAttackDamage;
    private int dodgeChance;

    public Manio(String name, int health, int minAttackDamage, int maxAttackDamage, int dodgeChance) {
        super(name, health, 0);
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.dodgeChance = dodgeChance;
    }

    @Override
    public int getAttackDamage() {
        int attack = (int) (Math.random() * (maxAttackDamage - minAttackDamage)) + minAttackDamage;
            return attack;
        }

    @Override
    public void receiveDamage(int damage) {
        if (Math.random() < (dodgeChance / 100.0)) {
            System.out.println(this.getName() + " dodged the incoming attack!");
        } else {
            System.out.println(this.getName() + " is hit for " + damage + " damage.");
            super.receiveDamage(damage);
        }
    }
}