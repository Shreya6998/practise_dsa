package Tree;

public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        // ✅ Test Case 1 (Balanced)
        TreeNode root1 =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)));

        System.out.println("Test1 Result: " + isBalanced(root1));


        // ❌ Test Case 2 (Not Balanced)
        TreeNode root2 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                null),
                        null);

        System.out.println("Test2 Result: " + isBalanced(root2));


        // ✅ Test Case 3 (Single Trees.Node)
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test3 Result: " + isBalanced(root3));
    }

    private static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return dfsHeight(root) != -1;
    }

    private static int dfsHeight(TreeNode root) {
        if(root == null) return 0;

        int left = dfsHeight(root.left);
        if(left == -1) return -1;

        int right = dfsHeight(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) <= 1)
            return 1 + Math.max(left, right);
        else
            return -1;
    }
}

