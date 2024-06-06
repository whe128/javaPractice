package C03;

import java.util.ArrayList;
import java.util.List;

public class TreeNode <T>{
    public T value;
    private List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T value){
        this.value = value;
    }
    public TreeNode<T> addChild(T value){
        TreeNode<T> node = new TreeNode<>(value);
        children.add(node);
        return node;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        // Format: (node (child-1) (child-2) (...))
        buffer.append("(");
        buffer.append(value);
        for(TreeNode<T> child : children){
            buffer.append(" ");
            buffer.append(child.toString());
        }
        buffer.append(")");
        return buffer.toString();
    }

    public static void main(String[] args) {
        TreeNode<String> node1 = new TreeNode<>("a");
        TreeNode<String> node2 = node1.addChild("b");
        TreeNode<String> node3 = node1.addChild("c");
        TreeNode<String> node4 = node2.addChild("d");
        TreeNode<String> node5 = node2.addChild("e");
        TreeNode<String> node6 = node3.addChild("e");
        System.out.println(node1);
    }
}
