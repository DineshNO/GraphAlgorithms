import sun.reflect.generics.tree.Tree;

public class NextNode {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createMinimalBST(new int[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        TreeNode next = findNextNodeToTraverse(tree);
        System.out.println(next.data);
    }

    private static TreeNode findNextNodeToTraverse(TreeNode n) {
        if(n.right != null) {
           return getLeftMostChild(n.right);
        }
        else{
            TreeNode q = n;
            TreeNode x = q.parent;
            while(x != null && x.left !=q){
                q = x;
                x = x.parent;
            }
        }
        return n;
    }

    private static TreeNode getLeftMostChild(TreeNode n) {
        if(n == null){
            return null;
        }
        while(n.left !=null){
            n = n.left;
        }
        return n;
    }
}
