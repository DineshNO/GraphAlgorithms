public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createMinimalBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        boolean isBalanced = isTreeBalanced(tree);
        System.out.println(isBalanced);
        System.out.println(isBalanced(tree));
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

    static int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE)return Integer.MIN_VALUE; // Pass error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        System.out.println("Left: "+ leftHeight + " Right:" + rightHeight + " node :"+ root.data);
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

}
