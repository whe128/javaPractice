package A0Myself;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSearch {

    public static <T> void preOrderDFS(TreeNode<T> node){
        //first print the value, then run the child node
        System.out.print(node.getValue()+ " ");
        for(TreeNode<T> child : node.getChildren()){
            preOrderDFS(child);
        }
    }
    public static <T> void postOrderDFS(TreeNode<T> node){
        //first print the value, then run the child node
        for(TreeNode<T> child : node.getChildren()){
            postOrderDFS(child);
        }
        System.out.print(node.getValue()+ " ");
    }

    public static <T> void stackPreOrderDFS(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode<T> popNode = stack.pop();
            System.out.print(popNode.getValue()+ " ");
            //because we put the b first, then we get b later, and get c first
            for(TreeNode<T> childNode: popNode.getChildren()){
                stack.push(childNode);
            }
        }
    }

    public static <T> void orderUseBFS(TreeNode<T> node){
        Queue<TreeNode<T>> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode<T> deQueueNode = queue.remove();
            System.out.print(deQueueNode.getValue()+ " ");
            //because we add b first, then we get b first
            for(TreeNode<T> child : deQueueNode.getChildren()){
                queue.add(child);
            }
        }
    }

    public static <T> boolean findPreOderDFS(TreeNode<T> node, T target){
        if(node.getValue().equals(target)){
            return true;
        }

        for(TreeNode child : node.getChildren()){
            if(findPreOderDFS(child,target)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode("a");
        TreeNode<String> b = root.addChild("b");
        TreeNode<String> c = root.addChild("c");
        TreeNode<String> d = b.addChild("d");
        TreeNode<String> e = b.addChild("e");
        TreeNode<String> f = c.addChild("f");
        System.out.println(root);

        preOrderDFS(root);
        System.out.println();

        stackPreOrderDFS(root);
        System.out.println();
        System.out.println();

        postOrderDFS(root);
        System.out.println();
        System.out.println();

        orderUseBFS(root);
        System.out.println();

        System.out.println(findPreOderDFS(root,"Z"));
    }
}
