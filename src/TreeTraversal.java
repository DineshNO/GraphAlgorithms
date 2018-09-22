public class TreeTraversal {
    static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createMinimalBST(new int[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(tree);
        inOrderTraversal(tree);
        System.out.println();
        preOrderTraversal(tree);
        System.out.println();
        postOrderTraversal(tree);
    }
}


