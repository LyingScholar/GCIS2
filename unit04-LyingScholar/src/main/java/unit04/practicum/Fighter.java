package unit04.practicum;

public class Fighter {
    private String name;
    public int health;
    private int attackDamage;

    public Fighter(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public boolean isUnconscious() {
        return health <= 0;
    }

    public String getName(){
        return name;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void receiveDamage(int damage) {
        health -= damage;
    }
}