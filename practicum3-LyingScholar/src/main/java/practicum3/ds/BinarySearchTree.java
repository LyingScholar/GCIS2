package practicum3.ds;

public class BinarySearchTree <T extends Comparable<T>> {
    
    protected BinaryNode <T> root;
    protected int size;

    public BinarySearchTree (T initialValue) {
        root = new BinaryNode <T> (initialValue);
        size = 1;
    }

    @Override
    public String toString () {
        return root.infixTraversal ();
    }

    public int size () {
        return size;
    }

    private boolean search (BinaryNode <T> node, T target) {
        if (node.getValue() == target) {
            return true;
        }

        if (node.getLeft () != null && target.compareTo (node.getValue ()) < 0) {
            if (search (node.getLeft (), target) == true) {
                return true;
            }
        }
        else if (node.getRight () != null) {
            if (search (node.getRight (), target)) {
                return true;
            }
        }

        return false;
    }

    public boolean search (T target) {
        return search (root, target);
    }

    private void insert (BinaryNode <T> node, T value) {
        if (value.compareTo (node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft (new BinaryNode <T> (value));
                size++;
            }
            else {
                insert (node.getLeft(), value);
            }
        }
        else {
            if (node.getRight () == null) {
                node.setRight (new BinaryNode <T> (value));
                size++;
            }
            else {
                insert (node.getRight (), value);
            }            
        }
    }

    public void insert (T value) {
        insert (root, value);
    }
    
}
