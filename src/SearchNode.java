public class SearchNode {

    public static TreeNode search(TreeNode tree,TreeNode searchNode){
        if(tree != null && tree.equals(searchNode)){
            return tree;
        }
        if(tree.data > searchNode.data){
            return search(tree.left,searchNode);
        }
        else{
            return search(tree.right,searchNode);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createMinimalBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        TreeNode a = new TreeNode(2);
        TreeNode node = search(tree,a);
        System.out.println(node);
    }
}
