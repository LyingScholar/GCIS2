package unit09;

import java.util.stream.IntStream;

public class sum {
    private static int sum(int num){
        IntStream stream = IntStream.rangeClosed(1, num);
        stream.forEach(System.out::println);
        System.out.println();
        stream = IntStream.rangeClosed(1, num);
        return stream.sum();
    
    }

    @SuppressWarnings("unused")
    private static int shiftedSum(int num,int shift){
        IntStream stream = IntStream.rangeClosed(1, num);
        return stream.map(x -> x+shift).sum();
    
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(sum(20));
        System.out.println();
    }
}
