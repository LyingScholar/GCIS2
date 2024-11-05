package practicum3.ds;

public class BinaryNode <T> {
    private T value;
    private BinaryNode <T> left;
    private BinaryNode <T> right;

    public BinaryNode (T value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString () {
        return "BinaryNode {value: " + value + ", left: " + left +
               ", right: " + right + "}";
    }

    public T getValue () {
        return value;
    }

    public void setValue (T value) {
        this.value = value;
    }

    public BinaryNode <T> getLeft () {
        return left;
    }

    public void setLeft (BinaryNode <T> left) {
        this.left = left;
    }

    public BinaryNode <T> getRight () {
        return right;
    }

    public void setRight (BinaryNode <T> right) {
        this.right = right;
    }

    public String infixTraversal () {
        String tree = "";
        if (left != null) {
            tree += left.infixTraversal ();
        }

        tree += value + " ";

        if (right != null) {
            tree += right.infixTraversal ();
        }

        return tree;
    }

    public boolean search (T target) {
        if (value == target) {
            return true;
        }

        if (left != null) {
            if (left.search (target) == true) {
                return true;
            }
        }

        if (right != null) {
            if (right.search (target)) {
                return true;
            }
        }

        return false;
    }
}