public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createMinimalBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,2,3,4,5,6,7});
        boolean isBalanced = isTreeBalanced(tree);
        System.out.println(isBalanced);
    }

    private static boolean isTreeBalanced(TreeNode root) {
        if (root == null) return true;
        int diffInDepth = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(diffInDepth) > 1) {
            return false;
        } else {
            return isTreeBalanced(root.left) && isTreeBalanced(root.right);
        }
    }

    private static int getHeight(TreeNode n) {
        if (n == null) {
            return -1;
        }
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }


}
