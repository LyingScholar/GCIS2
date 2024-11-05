package unit06;

public class BinaryNode<E> {
    private E value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public BinaryNode( E value, BinaryNode<E> left, BinaryNode<E> right){
        this.value = value;
        this.left = left;
        this.right = right;

    }

    public BinaryNode(E value){
        this(value, null, null);
    }

    public E getValue(){
        return value;
    }

    public void setValue(E value){
        this.value = value;
    }

    public BinaryNode<E> getLeft(){
        return left;
    }
    
    
    public void setLeft(BinaryNode<E> left){
        this.left = left;
    }

    public BinaryNode<E> getRight(){
        return right;
    }

    public void setRight(BinaryNode<E> right){
        this.right = right;
    }

    @Override
    public String toString(){
        return "BinaryNode{value=" + value
        + ", left=" + left
        + ", right" + right
        + "}";
    }

    public String infixTransversal(){
        String string = "";
        if(left != null){
            string+= left.infixTransversal();
        }
        string += value + " ";
        if(right != null){
            string+= right.infixTransversal();
        }
        return string;
    }

    public boolean search(E target){
        if (target == value){
            return true;
        }
        boolean found = false;
        if(left != null){
            found = left.search(target);
        }
        if(!found && right !=  null){
            found = right.search(target);
        }
        return found;
    }

    public static void main(String[] args) {
        //make nodes
        // BinaryNode root = new BinaryNode(2);
        // BinaryNode bn3 = new BinaryNode(3);
        // BinaryNode bn7 = new BinaryNode(7);
        // BinaryNode bn9 = new BinaryNode(9);
        // BinaryNode bn4 = new BinaryNode(4);
        // BinaryNode bn1 = new BinaryNode(1);
        // BinaryNode bn6 = new BinaryNode(6);
    

        // root.setLeft(bn3);
        // root.setRight(bn7);
        // bn3.setLeft(bn9);
        // bn3.setRight(bn4);
        // bn7.setLeft(bn1);
        // bn7.setRight(bn6);

        // // BinaryNode root = new BinaryNode(2,
        // // new BinaryNode(3,
        // // new BinaryNode(9),
        // // new BinaryNode(4)),
        // // new BinaryNode(7,
        // // new BinaryNode(1),
        // // new BinaryNode(6)));
        // System.out.println();
        // System.out.println(root);

        // System.out.println();
        // System.out.println(root.infixTransversal());

        // System.out.println();
        // System.out.println("9: " + root.search(9));
        // System.out.println("2: " + root.search(2));
        // System.out.println("6: " + root.search(6));
        // System.out.println("5: " + root.search(5));
        // System.out.println();


        BinaryNode<String> root = new BinaryNode<>("Root");
        BinaryNode<String> bnLeft = new BinaryNode<>("Left");
        BinaryNode<String> bnRight = new BinaryNode<>("Right");
        BinaryNode<String> bnLeftLeft = new BinaryNode<>("Left-Left");
        BinaryNode<String> bnLeftRight = new BinaryNode<>("Left-Right");
        BinaryNode<String> bnRightLeft = new BinaryNode<>("Right-Left");
        BinaryNode<String> bnRightRight = new BinaryNode<>("Right-Right");

        root.setLeft(bnLeft);
        root.setRight(bnRight);
        bnLeft.setLeft(bnLeftLeft);
        bnLeft.setRight(bnLeftRight);
        bnRight.setLeft(bnRightLeft);
        bnRight.setRight(bnRightRight);

        System.out.println();
        System.out.println(root);

        System.out.println();
        System.out.println(root.infixTransversal());

        System.out.println();
        System.out.println("Left: " + root.search("Left"));
        System.out.println("Root: " + root.search("Root"));
        System.out.println("Right: " + root.search("Right"));
        System.out.println("Search: " + root.search("Search"));
        System.out.println();

    }
}