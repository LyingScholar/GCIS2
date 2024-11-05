package unit02.SWB;

public class Ship {
    private String name;
    private int hullAmount;
    private int shields;
    private String weapons;


    public Ship(String name, int hullAmount, int shields, String weapons){
        this.name = name;
        this.hullAmount = hullAmount;
        this.shields = shields;
        this.weapons = weapons;
    }
    //2/6
    public Ship(String name, int hullAmount){
        this(name,hullAmount,0,"Plasma Ray");
    }


    public String getName(){
        return name;
    }

    public int getHullAmount(){
        return hullAmount;
    }


    public int getShields(){
        return shields;
    }

    public String getWeapons(){
        return weapons;
    }

    //2//11
    @Override
    public String toString(){
        return name + ": shields " + shields + ", hull " + hullAmount;
    }
}