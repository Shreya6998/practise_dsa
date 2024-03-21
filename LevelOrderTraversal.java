package dsaProblems;

import java.util.*;
public class LevelOrderTraversal {
	
	// Node of a binary tree
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static ArrayList<Integer> traversal(Node root){
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.poll();
			result.add(temp.data);
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// Binary Tree Formation
		Node root = new Node(4);		/*	      4	      */
		root.left = new Node(2);	    /*      /   \	  */
		root.right = new Node(5);	    /*	   2     5    */
		root.left.left = new Node(7);   /*	  / \   / \   */
		root.left.right = new Node(1);  /*   7   1 2   3  */
		root.right.left = new Node(2); 	/*	    /         */
		root.right.right = new Node(3); /*	   6		  */
		root.left.right.left = new Node(6);
	
		System.out.println(traversal(root));

	}

}
