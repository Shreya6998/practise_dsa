package BST;

import java.util.*;
public class LowestCommonAncestor {

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
                6
               / \
              2   8
             / \ / \
            0  4 7  9
              / \
             3   5
        */

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;          // node 2
        TreeNode q = root.left.right;   // node 4

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println(lca.val);
    }


    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            if(p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            else if(p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            else { return curr; }
        }
        return null;
    }
}

