package unit02.SWB;

import java.util.Arrays;

//2.2
public class StarWarsBattle {
    //2/14 adding constants
    public static final String X_WING = "X-Wing";
    public static final String TIE_FIGHTER = "TIE Fighter";
    public static final String TAIM_AND_BAK = "Taim & Bak KX9 Laser Cannon";
    public static final String L_S1 = "L-s1 LAser Cannon";


    public static void main(String[] args) {
        Weapon laser = new Weapon(L_S1, DamageType.HEAVY, 50);
        System.out.println("Weapon: " + laser.getName());
        System.out.println("damage amt: " + laser.getDamageAmount());
        System.out.println("damage type: " + laser.getDamageType().getColor());
        System.out.println();

        //2/5
        Ship myShip = new Ship(X_WING, 100,100,"Laser");
        System.out.println("Ship: " + myShip.getName());
        System.out.println("hull amt: "+ myShip.getHullAmount());

        Weapon tab = new Weapon(TAIM_AND_BAK,DamageType.NORMAL, 15);

        //2/6
        Ship otherShip = new Ship(TIE_FIGHTER, 50,40,tab.getName());
        System.out.println("Ship: " + otherShip.getName());
        System.out.println("hull amt: "+ otherShip.getHullAmount());
        System.out.println("shields: " + otherShip.getShields());
        System.out.println("weapons: " + otherShip.getWeapons());


        //2/11
        System.out.println();
        System.out.println(myShip);
        System.out.println(otherShip);
        System.out.println(laser);

        //2/12
        System.out.println();
        Weapon laserX = new Weapon("laser", DamageType.HEAVY,50);
        Weapon laserY = new Weapon("laser", DamageType.ION,50);
        System.out.println("laser = laserX? " + laser.equals(laserX));
        System.out.println("laserX = laserY? " + laserX.equals(laserY));
        System.out.println("laserY = laser? " + laserY.equals(laser));

        //2/13
        System.out.println();
        String heavy = DamageType.HEAVY.toString();
        System.out.println(heavy);
        String normal = DamageType.NORMAL.toString();
        System.out.println(normal);
        String ion = DamageType.ION.toString();
        System.out.println(ion);
        System.out.println();
        DamageType heavy2 = DamageType.valueOf(heavy);
        System.out.println(heavy2);
        DamageType normal2 = DamageType.valueOf(normal);
        System.out.println(normal2);
        DamageType ion2 = DamageType.valueOf(ion);
        System.out.println(ion2);
        System.out.println();
        
        DamageType[] values = DamageType.values();
        System.out.println(Arrays.toString(values));
        System.out.println();

    }
}
