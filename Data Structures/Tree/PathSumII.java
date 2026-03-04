package Tree;

import java.util.*;

public class PathSumII {

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

        // Example Tree
        //
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11  13  4
        //   /  \     /
        //  7    2   5

        TreeNode root =
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(7),
                                        new TreeNode(2)),
                                null),
                        new TreeNode(8,
                                new TreeNode(13),
                                new TreeNode(4,
                                        new TreeNode(5),
                                        null)));

        System.out.println("Result: " + pathSum(root, 22));

        // Example Tree
        //
        //        5
        //       /
        //      4
        //     /
        //    11
        //   /
        //  2

        root =new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(2),
                                        null),
                                null),
                        null);

        System.out.println("Result: " + pathSum(root, 22));

        // Example Tree
        //
        //        1
        //       / \
        //      2   3

        root =
              new TreeNode(1,
                        new TreeNode(2, null,null),
                        new TreeNode(3, null,null));

        System.out.println("Result: " + pathSum(root, 5));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum(new ArrayList<>(), root, targetSum);
    }

    private static List<List<Integer>> pathSum(List<Integer> path, TreeNode root, int targetSum) {
        if(root == null) return Collections.emptyList();

        List<List<Integer>> paths = new ArrayList<>();
        path.add(root.val);

        if(root.left == null && root.right == null && root.val==targetSum) {
            paths.add(new ArrayList<>(path));
        } else {
            paths.addAll(pathSum(path, root.left, targetSum - root.val));
            paths.addAll(pathSum(path, root.right, targetSum - root.val));
        }
        path.removeLast();
        return paths;
    }
}

