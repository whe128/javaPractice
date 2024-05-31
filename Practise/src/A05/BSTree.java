package A05;

public class BSTree<T extends Comparable<T>>{
    T value;
    BSTree left,right;

    BSTree(T value){
        this.value = value;
    }

    boolean add(T element){
        //first we create a new node
        BSTree node = new BSTree(element);
        return addToBranch(node);
    }

    boolean addToBranch(BSTree subTree){
        if(subTree==null){
            return false;
        }
        if(subTree.value.compareTo(this.value)<0){
            if(this.left==null){
                this.left=subTree;
                return true;
            }
            else {
                return left.addToBranch(subTree);
            }
        }
        else if(subTree.value.compareTo(this.value)>0) {
            if(this.right==null){
                this.right=subTree;
                return true;
            }
            else {
                return right.addToBranch(subTree);
            }
        }
        return false;
    }

    boolean contains(T element){
        //left
        if(element.compareTo(this.value)<0){
            if(this.left==null){
                return false;
            }
            else {
                return this.left.contains(element);
            }
        }//right
        else if(element.compareTo(this.value)>0){
            if(this.right==null){
                return false;
            }
            else {
                return this.right.contains(element);
            }
        }//equal
        else if(element.compareTo(this.value)==0){
            return true;
        }
        return false;
    }

    BSTree removeNodeContaining(T element){
        if(element.compareTo(value)<0){
            if(left==null){
                return null;
            }
            if(this.left.value.compareTo(element)==0){
                BSTree found = left;
                left = null;
                return found;
            }
            else {
                return left.removeNodeContaining(element);
            }
        }
        else if(element.compareTo(value)>0){
            if(right==null){
                return null;
            }
            if(this.right.value.compareTo(element)==0){
                BSTree found = right;
                right = null;
                return found;
            }
            else {
                return right.removeNodeContaining(element);
            }
        }
        else{
            //can not remove itself
            throw new IllegalStateException("tried to remove current node from the tree");
        }


    }
    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();
        builder.append("(");
        builder.append(value);
        builder.append(" ");
        builder.append(left==null?"null":left.toString());
        builder.append(" ");
        builder.append(right==null?"null":right.toString());
        builder.append(")");
        return builder.toString();
    }


    public static void main(String[] args) {
        BSTree bsTree = new BSTree(0);
        bsTree.add(-1);
        bsTree.add(1);
        bsTree.add(10);
        System.out.println(bsTree);
        bsTree.add(100);
        System.out.println(bsTree);
        bsTree.add(100);
        System.out.println(bsTree);
    }
}
