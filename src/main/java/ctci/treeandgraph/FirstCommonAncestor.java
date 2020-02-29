package ctci.treeandgraph;

/* @author Shambhuraj created on 2/28/2020*/
/*Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.*/
public class FirstCommonAncestor {

    public static class Result {
        TreeNode node;
        boolean isFCA;

        public Result(TreeNode node, boolean isFCA) {
            this.node = node;
            this.isFCA = isFCA;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        TreeNode firstNode = root.left.left;
        TreeNode secondNode = root.left.right.right;
        Result fca = findFCA(root, firstNode, secondNode);
        System.out.println(fca.node.data);
    }

    private static Result findFCA(TreeNode root, TreeNode firstNode, TreeNode secondNode) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == firstNode && root == secondNode) {
            return new Result(root, true);
        }
        Result leftResult = findFCA(root.left, firstNode, secondNode);
        if (leftResult.isFCA) {
            return leftResult;
        }

        Result rightResult = findFCA(root.right, firstNode, secondNode);
        if (rightResult.isFCA) {
            return leftResult;
        }

        if (leftResult.node != null && rightResult.node != null) {
            return new Result(root, true);
        } else if (root == firstNode || root == secondNode) {
            boolean isFCA = leftResult.node != null || rightResult.node != null;
            return new Result(root, isFCA);
        } else {
            return new Result(leftResult.node != null ? leftResult.node : rightResult.node, false);
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
