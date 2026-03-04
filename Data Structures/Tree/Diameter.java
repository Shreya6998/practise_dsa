package Tree;

import java.util.*;

public class Diameter {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;   // global tracker

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
                 \
                  6
                 /
                7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode(7);

        int result = diameterOfBinaryTree(root);
        System.out.println(result);
    }

    /* Diameter is the number of edges (not nodes) along the longest path
    between any two nodes in the tree. Path may or may not pass through root*/
    private static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }


    private static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // update diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
