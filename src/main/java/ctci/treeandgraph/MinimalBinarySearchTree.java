package ctci.treeandgraph;
/* @author Shambhuraj created on 2/21/2020*/

public class MinimalBinarySearchTree {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = createTree(array, 0, array.length - 1);
        printTree(treeNode);
    }


    private static TreeNode createTree(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(array[mid]);
        treeNode.left = createTree(array, start, mid - 1);
        treeNode.right = createTree(array, mid + 1, end);
        return treeNode;
    }

    //In order  
    private static void printTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTree(treeNode.left);
        System.out.print(treeNode.data);
        printTree(treeNode.right);
    }

}
