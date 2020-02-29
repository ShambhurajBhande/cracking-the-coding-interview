package ctci.treeandgraph;/* @author Shambhuraj created on 2/29/2020*/

/*Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
That is, if you cut off the tree at node n, the two trees would be identical.*/
public class CheckSubTree {
    public static void main(String[] args) {
        TreeNode bTree = createBinaryTree();
        TreeNode subTree = createSubTree();
        boolean isSubTree = checkSubTree(bTree, subTree);
        System.out.println(isSubTree);
    }

    private static boolean checkSubTree(TreeNode bTree, TreeNode subTree) {
        if (subTree == null) return false;
        return subTree(bTree, subTree);
    }

    private static boolean subTree(TreeNode bTree, TreeNode subTree) {
        if (bTree == null) {
            return false;
        } else if (bTree.data == subTree.data && matchTree(bTree, subTree)) {
            return true;
        }
        return subTree(bTree.left, subTree) || subTree(bTree.right, subTree);

    }

    private static boolean matchTree(TreeNode bTree, TreeNode subTree) {
        if (bTree == null && subTree == null)
            return true;
        else if (bTree == null || subTree == null)
            return false;
        else if (bTree.data != subTree.data)
            return false;
        else
            return matchTree(bTree.left, subTree.left) && matchTree(bTree.right, subTree.right);
    }


    private static TreeNode createBinaryTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode2 = treeNode.left;
        treeNode2.left = new TreeNode(5);
        treeNode2.right = new TreeNode(6);

        TreeNode treeNode3 = treeNode.right;
        treeNode3.left = new TreeNode(7);
        treeNode3.right = new TreeNode(8);

        TreeNode treeNode4 = treeNode2.right;
        treeNode4.left = new TreeNode(9);
        treeNode4.right = new TreeNode(10);
        return treeNode;
    }

    private static TreeNode createSubTree() {
        TreeNode treeNode2 = new TreeNode(6);
        treeNode2.left = new TreeNode(9);
        treeNode2.right = new TreeNode(10);
        return treeNode2;
    }
}
