package my;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode<T> {
  private T value;
  private List<TreeNode<T>> children = new ArrayList<>();

  public TreeNode ( T value){
      this.value = value;
    }

    public TreeNode<T> addChild(T value){
      TreeNode<T> node = new TreeNode<>(value);
      children.add(node);
      return node;
    }

    public List<TreeNode<T>> getChildren(){
      return Collections.unmodifiableList(children);
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();
        //format: (node(child-1) (child-2) (...))

        builder.append("(");
        builder.append(value);          //first is itself

        for(TreeNode<T> child : children){
            builder.append(" ");
            builder.append(child.toString());
        }
        builder.append(")");
        return builder.toString();
    }

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode("a");
        TreeNode<String> b = root.addChild("b");
        TreeNode<String> c = root.addChild("c");
        TreeNode<String> d = b.addChild("d");
        TreeNode<String> e = b.addChild("e");
        TreeNode<String> f = c.addChild("f");
        System.out.println(root);
    }
}
