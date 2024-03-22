package dsaProblems;

import java.util.*;
public class DiagonalBinaryTree {

	public static void main(String[] args) {
        // build binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(11);
        root.right.left.right = new Node(12);
        root.right.right.left = new Node(13);
        root.right.right.right = new Node(14);

        // Function Call
        ArrayList<Integer> v = diagonalElements(root);
 
        // print the diagonal sums
        for (int i = 0; i < v.size(); i++)
            System.out.print(v.get(i) + " ");

	}

	static ArrayList<Integer> diagonalElements(Node root) {
		ArrayList<Integer> elements = new ArrayList<>();
		
		Queue<Node> main = new LinkedList<>();
		main.add(root);
		
		Queue<Node> sub = new LinkedList<>();
		
		while(!main.equals(sub)) {
			int sum = 0;
			while(!main.isEmpty()) {
				Node temp = main.poll();
				sum += temp.data;
				if(temp.left != null) {
					sub.add(temp.left);
				}
				if(temp.right != null) {
					main.add(temp.right);
				}
			}
			elements.add(sum);
			main.addAll(sub);
			sub.clear();
		}
		
		return elements;
	}

}
