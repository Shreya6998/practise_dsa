package Tree;

import java.util.*;

public class NextRightPointers {

    static class Node {
        int val;
        Node left, right, next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   7
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);

        connect(root);

        // Print using next pointers to verify
        printLevelsUsingNext(root);
    }

    private static void connect(Node root) {
        if (root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null, curr;
            for(int i=0; i<size; i++) {
                //Process the current node
                curr = queue.remove();
                if(prev != null)
                    prev.next = curr;
                prev = curr;
                //Add child nodes to the queue
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);

            }
        }
    }

    // Helper: prints level by level using next pointers
    private static void printLevelsUsingNext(Node root) {
        Node levelStart = root;

        while(levelStart != null) {
            Node curr = levelStart;
            levelStart = null;

            while(curr != null) {
                System.out.print(curr.val + " -> ");

                // find start of next level
                if(levelStart == null) {
                    if(curr.left != null) levelStart = curr.left;
                    else if(curr.right != null) levelStart = curr.right;
                }

                curr = curr.next;
            }
            System.out.println("null");
        }
    }
}

