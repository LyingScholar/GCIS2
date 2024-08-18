package unit02;
//2/25
import java.util.Arrays;

public class Oobject {
    public static Object[] funWithObjects(Object obj){
        Object[] array = new Object[5];

        array[0] = obj.toString();
        array[1] = 123.456f;
        array[2] = new Year(2024);

        int[] ints = {1,2,3,5};
        
        array[4] = ints;

        return array;

    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(Arrays.toString(funWithObjects("abcd")));
        System.out.println(Arrays.toString(funWithObjects(1234)));
        System.out.println(Arrays.toString(funWithObjects(new int[4])));

    }
}
