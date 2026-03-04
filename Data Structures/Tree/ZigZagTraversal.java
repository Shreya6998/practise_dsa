package Tree;

import java.util.*;

public class ZigZagTraversal {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        List<List<Integer>> result = zigZagTraversal(root);
        System.out.println(result);
    }

    private static List<List<Integer>> zigZagTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null) return output;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];
            // Process current level
            for(int i=0; i<size;i++) {
                // Process curr element
                TreeNode curr = queue.remove();

                // Update output
                if(leftToRight)
                    level[i]=curr.val;
                else
                    level[size-1-i]=curr.val;

                // Add child nodes to queue
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            output.add(Arrays.asList(level));
            // Flip the flag
            leftToRight = !leftToRight;
        }
        return output;
    }

    static ArrayList<Integer> traversal(TreeNode root){
        //Setting this variable to determine which direction to move in.
        //If the value is 0, move in left
        //If the value is 1, move in right
        int direction = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> sublevel = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i=0; i<size;i++) {
                TreeNode temp = dq.poll();
                sublevel.add(temp.val);
                if(temp.left != null)
                    dq.add(temp.left);
                if(temp.right != null)
                    dq.add(temp.right);
            }
            if(direction == 1) {
                Collections.reverse(sublevel);
            }
            result.addAll(sublevel);
            sublevel.clear();
            direction = direction^1;
        }

        return result;
    }

}
