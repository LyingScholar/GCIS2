package unit10.practicum;

public class BinaryOps {
    public interface BinaryLogicalOp {
        boolean compute(boolean a,boolean b);
    }

    public static boolean logicalAnd(boolean a, boolean b){
        return a&&b;
    }

    public static void main(String[] args) {
        // boolean a;
        // boolean b;
        boolean[] booleanValues = {false, true};

        BinaryLogicalOp and = Boolean::logicalAnd;
        BinaryLogicalOp or = new BinaryLogicalOp() {
            @Override
            public boolean compute(boolean a, boolean b) {
                return a || b;
            }
        };
        BinaryLogicalOp xor = (a, b) -> a ^ b;

        for (boolean a : booleanValues) {
            for (boolean b : booleanValues) {
                System.out.println("A: " + a +", B: "+ b
                +", AND: " +and.compute(a, b)
                +", OR: " +or.compute(a, b)
                +", XOR: "+ xor.compute(a, b)
                );
            };
                // A: false, B: false, AND: false, OR: false, XOR: false
                // A: false, B: true, AND: false, OR: true, XOR: true
                // A: true, B: false, AND: false, OR: true, XOR: true
                // A: true, B: true, AND: true, OR: true, XOR: false
            }
    }
}
