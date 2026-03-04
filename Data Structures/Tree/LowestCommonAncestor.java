package Tree;

public class LowestCommonAncestor {

    static boolean foundP, foundQ;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Test 1: Different subtrees
        TreeNode lca = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(lca != null ? lca.val : null); // Expected: 3

        // Test 2: One node ancestor of another
        lca = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(lca != null ? lca.val : null); // Expected: 5

        // Test 3: Same subtree deeper
        lca = lowestCommonAncestor(root, root.left.right.left, root.left.right.right);
        System.out.println(lca != null ? lca.val : null); // Expected: 2

        // Test 4: Nodes on opposite sides deeper
        lca = lowestCommonAncestor(root, root.left.left, root.right.right);
        System.out.println(lca != null ? lca.val : null); // Expected: 3

    }

    // Use this optimised version when either p or q or both may be absent
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foundP = false;
        foundQ = false;

        TreeNode lca = findLCA(root,p,q);
        if(foundP && foundQ)
            return lca;

        return null;
    }

    // Use this simple version when p & q are guaranteed to be present in the tree
    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(root == p) {
            foundP = true;
            return root;
        }

        if (root == q) {
            foundQ = true;
            return root;
        }

        if(left != null && right != null)
            return root;
        else
            return (left != null) ? left : right;
    }
}
