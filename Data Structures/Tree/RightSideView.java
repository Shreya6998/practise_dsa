package Tree;

import java.util.*;

public class RightSideView {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // ---------- Test 1 : Perfect Binary Tree ----------
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        runTest("Perfect Binary Tree", t1);

        // ---------- Test 2 : Right Skewed ----------
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);
        t2.right.right.right = new TreeNode(4);
        runTest("Right Skewed", t2);

        // ---------- Test 3 : Left Skewed ----------
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.left.left = new TreeNode(3);
        t3.left.left.left = new TreeNode(4);
        runTest("Left Skewed", t3);

        // ---------- Test 4 : Mixed Missing Children ----------
        TreeNode t4 = new TreeNode(1);
        t4.left = new TreeNode(2);
        t4.right = new TreeNode(3);
        t4.left.right = new TreeNode(5);
        runTest("Mixed Children", t4);

        // ---------- Test 5 : Zigzag ----------
        TreeNode t5 = new TreeNode(1);
        t5.left = new TreeNode(2);
        t5.right = new TreeNode(3);
        t5.left.right = new TreeNode(5);
        t5.right.left = new TreeNode(6);
        t5.right.left.right = new TreeNode(7);
        runTest("Zigzag", t5);

        // ---------- Test 6 : Deep Right Hidden ----------
        TreeNode t6 = new TreeNode(1);
        t6.left = new TreeNode(2);
        t6.left.left = new TreeNode(3);
        t6.left.right = new TreeNode(4);
        t6.left.right.right = new TreeNode(5);
        runTest("Deep Right Hidden", t6);

        // ---------- Test 7 : Wide Tree ----------
        TreeNode t7 = new TreeNode(10);
        t7.left = new TreeNode(5);
        t7.right = new TreeNode(20);
        t7.left.left = new TreeNode(3);
        t7.left.right = new TreeNode(7);
        t7.right.left = new TreeNode(15);
        t7.right.right = new TreeNode(25);
        t7.right.left.right = new TreeNode(17);
        runTest("Wide Tree", t7);

        // ---------- Test 8 : Empty Tree ----------
        runTest("Empty Tree", null);
    }

    private static void runTest(String name, TreeNode root) {
        System.out.println("---- " + name + " ----");
        System.out.println(rightSideView(root));
        System.out.println();
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
            TreeNode curr = queue.remove();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                if (i == size - 1)
                    output.add(curr.val);
            }
        }
        return output;
    }
}

