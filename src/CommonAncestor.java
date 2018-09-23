public class CommonAncestor {

    private static TreeNode findCommonAnestor(TreeNode n1,TreeNode n2){
        int diffInDepth = depth(n1) - depth(n2);
        TreeNode first = diffInDepth > 0 ? n2 : n1;
        TreeNode second = diffInDepth > 0 ? n1 : n2;
        second = goUpBy(Math.abs(diffInDepth),second);
        while(first != second && first != null && second != null){
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    private static TreeNode goUpBy(int diffInDepth, TreeNode node) {
        while(diffInDepth > 0  && node !=null){
            node = node.parent;
            diffInDepth--;
        }
        return node;
    }

    private static int depth(TreeNode n) {
        int depth = 0;
        while(n != null){
            n = n.parent;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
      TreeNode tree = TreeNode.createMinimalBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) ;
      TreeNode a = tree.find(2);
      TreeNode b = tree.find(6);
      TreeNode ancestor = findCommonAnestor(a,b);
      System.out.println(ancestor);
    }
}
