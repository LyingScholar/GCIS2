package practicum1.shape;


public class ShapeMain {
    public static void main(String[] args) {

        Shape pentagon1 = new Pentagon("Pentagon1", 10);
        Shape pentagon2 = new Pentagon("Pentagon2", 10);
        Shape pentagon3 = new Pentagon("Largest Pentagon3", 20);

        System.out.println(pentagon1);
        System.out.println();
        System.out.println(pentagon2);
        System.out.println();
        System.out.println(pentagon3);
        System.out.println();

        System.out.println("pentagon1 equals pentagon2: " + pentagon1.equals(pentagon2));
        System.out.println();
        System.out.println("pentagon1 equals pentagon3: " + pentagon1.equals(pentagon3));
        System.out.println();
    }
}