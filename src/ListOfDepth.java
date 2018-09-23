import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepth {

    public static void main(String[] args) {
        TreeNode node = TreeNode.createMinimalBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ArrayList<LinkedList<TreeNode>> listOfDepths = getListOfDepths(node);
        System.out.println(listOfDepths);
        ArrayList<LinkedList<TreeNode>> getListOfDepths_recusrsive = getListOfDepths_recusrsive(node);
        System.out.println(getListOfDepths_recusrsive);
    }

    private static ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode node) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        LinkedList<TreeNode> unVisited = new LinkedList<>();
        unVisited.add(node);
        while (!unVisited.isEmpty()) {
            lists.add(unVisited);
            LinkedList<TreeNode> parents = unVisited; //Go to next level
            unVisited = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    unVisited.add(parent.left);
                }
                if (parent.right != null) {
                    unVisited.add(parent.right);
                }
            }
        }
        return lists;
    }


    private static ArrayList<LinkedList<TreeNode>> getListOfDepths_recusrsive(TreeNode node) {
        int level = 0;
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        depths(node,level,lists);
        return lists;
    }

    private static  void  depths(TreeNode node, int level, ArrayList<LinkedList<TreeNode>> lists) {
        if(node == null) return ;
        LinkedList<TreeNode> list = null;
        if (lists.size()== level) {
            list = new LinkedList<>();
            lists.add(list);
        }
        else{
            list = lists.get(level);
        }
        list.add(node);
        depths(node.left,level+1,lists);
        depths(node.right,level+1,lists);
    }
}
