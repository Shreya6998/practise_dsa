package dsaProblems;

import java.util.*;

public class LowestCommonAncestor {

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
        
        Node ans = lowestCommonAncestor(root, 6, 5);
        System.out.println(ans.data);

	}
	
	static Boolean findNode(Node root, int p, int q) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp.data == p || temp.data == q)
				return true;
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		return false;
	}

	static Node lowestCommonAncestor(Node root, int p, int q) {
		if(root == null)
			return null;
		
		if(root.data == p || root.data == q)
			return root;
		
		//Find node in left and right child
		Boolean isLeft = false, isRight = false;
        if(root.left != null)
		    isLeft = findNode(root.left, p, q);
        if(root.right != null)
    		isRight = findNode(root.right, p, q);
		if(isLeft && isRight)
			return root;
		else if(isLeft)
			return lowestCommonAncestor(root.left, p, q);
		else 
			return lowestCommonAncestor(root.right, p, q);

	}

}
