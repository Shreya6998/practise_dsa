package dsaProblems;

import java.util.*;
public class ZigZagTraversal{
	
	static ArrayList<Integer> traversal(Node root){
		//Setting this variable to determine which direction to move in.
	    //If the value is 0, move in left
	    //If the value is 1, move in right
	    int direction = 0;
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> sublevel = new ArrayList<>();
		Deque<Node> dq = new LinkedList<>();
		dq.add(root);
		while(!dq.isEmpty()){
			int size = dq.size();
			for(int i=0; i<size;i++) {
				Node temp = dq.poll();
				sublevel.add(temp.data);
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

	public static void main(String[] args) {
		// Binary Tree Formation
		Node root = new Node(4);		/*	       4	      */
		root.left = new Node(2);	    /*      /     \	      */
		root.right = new Node(5);	    /*	   2       5      */
		root.left.left = new Node(7);   /*	  / \     / \     */
		root.left.right = new Node(1);  /*   7   1   2   3    */
		root.right.left = new Node(2); 	/*	/ \ / \ / \ / \   */
		root.right.right = new Node(3); /*  4 8 6 9 6 4 7 1   */
		root.left.left.left = new Node(4);
		root.left.left.right = new Node(8);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(9);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(4);
		root.right.right.left = new Node(7);
		root.right.right.right = new Node(1);
	
		System.out.println(traversal(root));

	}

}
