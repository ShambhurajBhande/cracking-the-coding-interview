package ctci.treeandgraph;/* @author Shambhuraj created on 2/22/2020*/
/*List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).*/
import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    public static void main(String[] args) {

        TreeNode treeNode = createBinaryTree();
        ArrayList<LinkedList> arrayList = createLinkedListByLevel(treeNode);
        printListDepth(arrayList);

    }

    private static void printListDepth(ArrayList<LinkedList> arrayList) {
        for (LinkedList list : arrayList) {
            for (Object data : list) {
                System.out.print(((TreeNode) data).data + ",");
            }
            System.out.println();
        }
    }

    private static ArrayList createLinkedListByLevel(TreeNode treeNode) {
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (treeNode != null) {
            current.add(treeNode);
        }
        while (current.size() > 0) {
            arrayList.add(current);
            LinkedList<TreeNode> parent = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode node : parent) {
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }
            }
        }
        return arrayList;
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

}

