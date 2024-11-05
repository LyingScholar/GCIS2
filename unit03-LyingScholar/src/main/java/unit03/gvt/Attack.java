package unit03.gvt;

public class Attack {
    private final String name;
    private final int[] hits;
    private final DamageType damageType;

    public Attack(String name, int[] hits, DamageType damageType) {
        this.name = name;
        this.hits = hits;
        this.damageType = damageType;
    }
    
    public int[] getHits(){
        return hits;
    }

    public String getName(){
        return name;
    }

    public DamageType getDamageType(){
        return damageType;

    }

    // @Override
    // public String

}
