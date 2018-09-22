public class BinarySearchTree {

    static Integer last_printed = null;

    static boolean checkBST(TreeNode n) {
        if (n == null) return true;
        if (!checkBST(n.left)) return false;
        if (last_printed != null && n.data <= last_printed) {
            return false;
        }
        last_printed = n.data;
        if (!checkBST(n.right)) return false;
        return true;// All good!
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createMinimalBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(checkBST(tree));
        System.out.println(minMaxSolution(tree));
    }

    private static boolean minMaxSolution(TreeNode root) {
        return minMaxSolution(root, null, null);
    }

    private static boolean minMaxSolution(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)){
            return false;
        }
        if (!minMaxSolution(n.left, min, n.data) || !minMaxSolution(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}
