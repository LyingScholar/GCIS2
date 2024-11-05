package unit02.chickens;

public class Egg {
    private final EggColor color;
    private final EggSize size;
    private boolean cracked;

    public Egg(EggColor color, EggSize size) {
        this.color = color;
        this.size = size;
        this.cracked = false;
    }



    public void crack() {
        this.cracked = true;
    }

    @Override
    public String toString() {
        return "An " + (cracked ? "uncracked" : "uncracked") + " " + size + " (" + size.getMinimumWeight() + "oz) " + color + " egg";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Egg)) return false;
        Egg otherEgg = (Egg) obj;
        return this.color == otherEgg.color && this.size == otherEgg.size && this.cracked == otherEgg.cracked;
        
    }
}