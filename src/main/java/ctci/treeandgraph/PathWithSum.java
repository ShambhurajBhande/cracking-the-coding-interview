package ctci.treeandgraph;

import java.util.HashMap;

/* @author Shambhuraj created on 3/2/2020*/
/*
* Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).*/
public class PathWithSum {

    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree();
        int paths = countPathWithSum(treeNode, 7);
        System.out.println(paths);
    }

    private static int countPathWithSum(TreeNode treeNode, int targetSum) {
        return countPathWithSum(treeNode, targetSum, 0, new HashMap<Integer, Integer>());

    }

    private static int countPathWithSum(TreeNode treeNode, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (treeNode == null) {
            return 0;
        }

        runningSum += treeNode.data;
        int sum = runningSum - targetSum;
        int totalPath = pathCount.getOrDefault(sum, 0);
        if (runningSum == targetSum) {
            totalPath++;
        }
        incrementPathCount(pathCount, runningSum, 1);
        totalPath += countPathWithSum(treeNode.left, targetSum, runningSum, pathCount);
        totalPath += countPathWithSum(treeNode.right, targetSum, runningSum, pathCount);
        incrementPathCount(pathCount, runningSum, -1);
        return totalPath;

    }

    private static void incrementPathCount(HashMap<Integer, Integer> pathCount, int runningSum, int delta) {
        int count = pathCount.getOrDefault(runningSum, 0) + delta;
        if (count == 0) {
            pathCount.remove(runningSum);
        } else {
            pathCount.put(runningSum, count);
        }
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
