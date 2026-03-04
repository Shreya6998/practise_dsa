package BST;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeNode insert(TreeNode root, int v) {
        if (root == null) { return new TreeNode(v);}
        if (v < root.val) {
            root.left = insert(root.left, v);
        } else  if (v > root.val) {
            root.right = insert(root.right, v);
        }
        return root;
    }

    private static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true; // base case
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    private static void levelByLevel(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;

        int[] values = {5, 3, 7, 2, 4, 8};
        for (int v : values) {
            root = insert(root, v);
        }

        boolean isValid = isValidBST(root);
        System.out.println(isValid);

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelByLevel(root);
    }
}
