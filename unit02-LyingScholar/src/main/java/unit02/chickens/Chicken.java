package unit02.chickens;

import java.util.Random;


public class Chicken {
    private static final EggColor[] EGG_COLORS = EggColor.values();
    private static final EggSize[] EGG_SIZES = EggSize.values();

    private static final Random RNG = new Random();


    private final String name;
    private final EggColor eggColor;
    private final EggSize eggSize;

    public Chicken(String name, EggSize eggSize, EggColor eggColor) {
        this.name = name;
        this.eggSize = eggSize;
        this.eggColor = eggColor;
    }

    public Egg layEgg() {
        boolean isCracked = RNG.nextBoolean();
        Egg egg = new Egg(eggColor, eggSize);
        if (isCracked) {
            egg.crack();
        }
        return egg;
    }

    @Override
    public String toString() {
        return name + ", a chicken that lays " + eggSize + " " + eggColor + " eggs";
    }

    public static Chicken generateRandomChicken() {
        String[] names = {"Chicken Little", "Hillary Fluff", "M-egg-tron", "Eggatha Christie", "Sal Monella", "Optimeggs Prime"};

        
        EggColor randomColor = EGG_COLORS[RNG.nextInt(EGG_COLORS.length)];
        EggSize randomSize = EGG_SIZES[RNG.nextInt(EGG_SIZES.length)];


        return new Chicken(names[RNG.nextInt(names.length)], randomSize, randomColor);
    }
}