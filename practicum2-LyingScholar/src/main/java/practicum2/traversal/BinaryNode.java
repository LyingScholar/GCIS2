package practicum2.traversal;

public class BinaryNode {
    private int value;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int value, BinaryNode left, BinaryNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(int value) {
        this(value, null, null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public String infixTraversal() {
        String string = "";
        if(left != null) {
            string += left.infixTraversal();
        }
        string += this.value + " ";
        if(right != null) {
            string += right.infixTraversal();
        }
        return string;
    }
    

    public String prefixTraversal() {
        String string = this.value + " ";
        if(left != null) {
            string += left.prefixTraversal();
        }
        if(right != null) {
            string += right.prefixTraversal();
        }
        return string;
    }

    public String postfixTraversal() {
        String string = "";
        if(left != null) {
            string += left.postfixTraversal();
        }
        if(right != null) {
            string += right.postfixTraversal();
        }
        string += this.value + " ";
        return string;
    }

    public static int summation(BinaryNode node) {
        if (node == null) return 0;
        return node.value + summation(node.left) + summation(node.right);
    }


    public static int findMinimumValue(BinaryNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }else{
        int minValue = node.value;
        int leftMin = findMinimumValue(node.left);
        int rightMin = findMinimumValue(node.right);

            if (leftMin < minValue){
                minValue = leftMin;
            }

            if (rightMin < minValue){
                minValue = rightMin;
            }
        return minValue;
        }
    }


    public static int findMaximumValue(BinaryNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int maxValue = node.value;
        int leftMax = findMaximumValue(node.left);
        int rightMax = findMaximumValue(node.right);
        if (leftMax > maxValue) maxValue = leftMax;
        if (rightMax > maxValue) maxValue = rightMax;
        return maxValue;
    }



    public static void main(String[] args) {
        // make nodes
        BinaryNode root = new BinaryNode(51);
        BinaryNode bn14 = new BinaryNode(14);
        BinaryNode bn55 = new BinaryNode(55);
        BinaryNode bn8 = new BinaryNode(8);
        BinaryNode bn15 = new BinaryNode(15);
        BinaryNode bn53 = new BinaryNode(53);
        BinaryNode bn2= new BinaryNode(2);
        BinaryNode bn9 = new BinaryNode(9);
        BinaryNode bn60 = new BinaryNode(60);
    
        // wire them together
        root.setLeft(bn14);
        root.setRight(bn55);
        bn14.setLeft(bn8);
        bn14.setRight(bn15);
        bn55.setLeft(bn53);
        bn55.setRight(bn60);
        bn8.setLeft(bn2);
        bn8.setRight(bn9);

        System.out.println();
        System.out.println("infix: " + root.infixTraversal());
        System.out.println("prefix: " + root.prefixTraversal());
        System.out.println("postfix: " + root.postfixTraversal());

        System.out.println();
        System.out.println("summation using postfix: " + summation(root));

        System.out.println();
        System.out.println("minimum using prefix: " + findMinimumValue(root));
        System.out.println();
        System.out.println("maximum using infix: " + findMaximumValue(root));

        System.out.println();
    }
}