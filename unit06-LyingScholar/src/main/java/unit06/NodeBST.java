package unit06;


public class NodeBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private BinaryNode<E> root;
    private int size;

    public NodeBST(){
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(E value) {
        if(root == null){
            root = new BinaryNode<>(value);
        }else{
            binaryInsert(root, value);
        }
        size +=1;
    }

    @Override
    public boolean search(E target) {
        if(this.size == 0){
            return false;
        }
        return binarySearch(root, target);
    }

    @Override
    public int size() {
        return size;
    }

    public void binaryInsert(BinaryNode<E> node, E value){
        if (value.compareTo(node.getValue()) < 0) {
            BinaryNode<E> left = node.getLeft();
            if (left != null) {
                binaryInsert(left, value);
            } else {
                node.setLeft(new BinaryNode<>(value));
            }
        } else {
            BinaryNode<E> right = node.getRight();
            if (right != null) {
                binaryInsert(right, value);
            } else {
                node.setRight(new BinaryNode<>(value));
            }
        }
    }


    private boolean binarySearch(BinaryNode<E> node, E target) {
        int comparison = target.compareTo(node.getValue());
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            BinaryNode<E> left = node.getLeft();
            return left != null && binarySearch(left, target);
        } else {
            BinaryNode<E> right = node.getRight();
            return right != null && binarySearch(right, target);
        }
    }

    @Override
    public String toString(){
        return root != null ? root.infixTransversal() :"<Empty>";
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new NodeBST<>();
        System.out.println();
        System.out.println(bst);

        System.out.println();
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(7);
        bst.insert(5);
        System.out.println(bst);

        System.out.println();
        System.out.println(3 + ": " + bst.search(3));
        System.out.println(  "9 : " + bst.search(9));
        System.out.println(7 + ": " + bst.search(7));
        System.out.println(8 + ": " + bst.search(8));

        System.err.println();
    }
}
