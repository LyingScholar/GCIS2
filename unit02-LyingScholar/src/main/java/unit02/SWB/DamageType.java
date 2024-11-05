package unit02.SWB;
//2/9
//2/10 convert enhanced enum
public enum DamageType {
    HEAVY("Green"),
    NORMAL("Red"),
    ION("Blue");

    private String color;

    private DamageType(String color) {
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    //2//13
    // @Override
    // public String toString(){
    //     return DamageType.toString() + DamageType.color.toString();
    // }
}
