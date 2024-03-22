package dsaProblems;

//Java implementation to find the sum of nodes
//on the longest path from root to leaf node
public class SumLongestPathBinaryTree {
	
	int maxSum, maxLen;
	
	int sumOfLongRootToLeafPathUtil(Node root) {
		if(root==null) {
			return 0;
		}
		
		maxSum = Integer.MIN_VALUE;
		maxLen = 0;
		
		sumOfLongRootToLeafPath(root, 0, 0);
		
		return maxSum;
	}
	
	void sumOfLongRootToLeafPath(Node root, int len, int sum) {
		if(root == null) {
			if(maxLen < len) {
				maxLen = len;
				maxSum = sum;
			}else if(maxLen == len && maxSum < sum) {
				maxSum = sum;
			}
			return;
		}
		
		//calling left child
		sumOfLongRootToLeafPath(root.left, len+1, sum+root.data);
		
		//calling right child
		sumOfLongRootToLeafPath(root.right, len+1, sum+root.data);

	}
	
	public static void main(String args[])
	{
		// binary tree formation
		Node root = new Node(4);		 /*	 4	 */
		root.left = new Node(2);		 /*	 / \	 */
		root.right = new Node(5);	 /*	 2 5	 */
		root.left.left = new Node(7); /*	 / \ / \	 */
		root.left.right = new Node(1); /* 7 1 2 3 */
		root.right.left = new Node(2); /*	 /		 */
		root.right.right = new Node(3); /*	 6		 */
		root.left.right.left = new Node(6);
	
		SumLongestPathBinaryTree obj = new SumLongestPathBinaryTree();
		System.out.println( "Sum = "
			+ obj.sumOfLongRootToLeafPathUtil(root));
	}

}
