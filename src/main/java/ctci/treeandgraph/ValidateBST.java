package ctci.treeandgraph;
/* @author Shambhuraj created on 2/27/2020*/
/*Validate BST: Implement a function to check if a binary tree is a binary search tree.*/
public class ValidateBST {
    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree();
        boolean isBST = validateBST(treeNode, null, null);
        System.out.println(isBST);
    }

    private static boolean validateBST(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }
        if ((min != null && treeNode.data <= min) || (max != null && treeNode.data > max)) {
            return false;
        }
        if(!validateBST(treeNode.left, null, treeNode.data) || !validateBST(treeNode.right,  treeNode.data,null)){
            return false;
        }
        return true;
    }

    private static TreeNode createBinaryTree() {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(9);

        TreeNode treeNode2 = treeNode.left;
        treeNode2.left = new TreeNode(5);

        TreeNode treeNode3 = treeNode.right;
        treeNode3.left = new TreeNode(7);
        treeNode3.right = new TreeNode(11);

        TreeNode treeNode4 = treeNode2.left;
        treeNode4.left = new TreeNode(3);
        treeNode4.right = new TreeNode(7);
        return treeNode;
    }
}
