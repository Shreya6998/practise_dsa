package BST;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallest {
    private static int count;
    private static int result;
    // Basic TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    /*
            5
           / \
          3   8
         / \
        1   4
    */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        int k = 3;

        int result = kthSmallest(root, k);
        System.out.println(result);
    }

    private static int kthSmallest1(TreeNode root, int k) {
        // Reset count and result to default
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }

    private static int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            // Travel to extreme left
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Trace back to leaf node
            curr = stack.pop();
            k--;

            if(k==0) return curr.val;

            // Move to right subtree
            curr = curr.right;
        }
        return -1;
    }
}

