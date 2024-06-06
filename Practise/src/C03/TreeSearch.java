package C03;

public class TreeSearch {
    /**
     * preOrder search
     *       1
     *      / \
     *     2   3
     *    / \ / \
     *   4  5 6  7
     *   result
     *   1 -> 2 -> 4 -> 5 -> 3 -> 6 -> 7。
     */
    public static <T> void preOrderDFS(TreeNode<T> node){
        System.out.print(node.value + " ");
        for(TreeNode<T> child:node.getChildren()){
            preOrderDFS(child);
        }
    }

    /**
     * postOrder search
     *       1
     *      / \
     *     2   3
     *    / \ / \
     *   4  5 6  7
     *   4 -> 5 -> 2 -> 6 -> 7 -> 3 -> 1
     */
    public static <T> void postOrderDFS(TreeNode<T> node){
        for(TreeNode<T> child: node.getChildren()){
            postOrderDFS(child);
        }
        System.out.print(node.value + " ");
    }

    public static <T> boolean findPreorderDFS(TreeNode<T> node, T target){
        if(node.value.equals(target)){
            return true;
        }
        for(TreeNode<T> child: node.getChildren()){
            if(findPreorderDFS(child,target)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("a");
        TreeNode<String> b = root.addChild("b");
        TreeNode<String> c = root.addChild("c");
        TreeNode<String> d = b.addChild("d");
        TreeNode<String> e = b.addChild("e");
        TreeNode<String> f = c.addChild("f");

        //preOrder search
        System.out.println(root);
        System.out.print("preOrder: ");
        preOrderDFS(root);
        System.out.println();

        //postOrder search
        System.out.print("postOrder: ");
        postOrderDFS(root);
        System.out.println();

        //find target
        System.out.println("find a : "+ findPreorderDFS(root,"a"));
        System.out.println("find b : "+ findPreorderDFS(root,"b"));
        System.out.println("find c : "+ findPreorderDFS(root,"c"));
        System.out.println("find d : "+ findPreorderDFS(root,"d"));
        System.out.println("find e : "+ findPreorderDFS(root,"e"));
        System.out.println("find f : "+ findPreorderDFS(root,"f"));
        System.out.println("find g : "+ findPreorderDFS(root,"g"));
        System.out.println("find h : "+ findPreorderDFS(root,"h"));
        System.out.println("find i : "+ findPreorderDFS(root,"i"));
        System.out.println("find j : "+ findPreorderDFS(root,"j"));
    }
}
