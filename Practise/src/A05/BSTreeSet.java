package A05;

import A03.Set;

import java.util.TreeSet;

/**
 * the core idea is that, we compare the element and the value of tree node, if not different,
 * we then compare the left and right, until the left , right becomes null
 * when we remove some node, the tree will be separated, so we need to add the separated tree to the root tree
 * @param <T>
 */

public class BSTreeSet<T extends Comparable<T>> implements Set<T>{
    private BSTree root;
    private int numElements;

    @Override
    public boolean add(T element) {
        if(root == null){
            root = new BSTree<>(element);
            numElements++;
            return true;
        }

        if(this.root.add(element)){
            numElements++;
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean contains(T value) {
        if(root == null){
            return false;
        }
        return root.contains(value);
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean remove(T value) {
        if (root == null) {
            return false;
        }
        //this is the core, when we remove, we should relink the tree
        if (root.value.compareTo(value) == 0) {
            BSTree left = root.left;
            BSTree right = root.right;
            //we let the left become the root, and the right become the sub tree of the root
            if (root.left != null) {
                root = left;
                root.addToBranch(right);
            } else {
                root = right;
            }
            numElements--;
            return true;
        }
        //then find the element in the sub tree
        //first get the tree
        //then add the left and right of the tree
        BSTree node = root.removeNodeContaining(value);
        if (node == null) {
            return false;
        } else {
            numElements--;
            root.addToBranch(node.left);
            root.addToBranch(node.right);
            return true;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

    }
}
