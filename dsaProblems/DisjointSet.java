package dsaProblems;

public class DisjointSet {
	int[] parent,rank;
	int n;
	
	public DisjointSet(int n) {
		parent = new int[n];
		rank = new int[n];
		this.n = n;
		makeSet(parent);
	}

	private void makeSet(int[] parent) {
		//Assign each element as its own parent
		for(int i=0; i<n ; i++) {
			parent[i] = i;
		}
		
	}
	
	//Find by Path Compression 
	public int find(int i) {
		//If parent of node is same as node, 
		//its the root node
		if(parent[i] == i) {
			return i;
		}
		
		//If its not root, making the root as parent of this node
		parent[i] = find(parent[i]);
		return parent[i];
		
	}
	
	///Union by Rank
	public void union(int i, int j) {
		int irep = find(i), jrep = find(j);
		
		if(irep == jrep)
			return;
		
		if(rank[irep] < rank[jrep]) {
			//Moving i root under j root
			parent[irep] = jrep;
		
		}else if(rank[jrep] < rank[irep]) {
			//Moving j root under i root
			parent[jrep] = irep;
		
		}else {
			//Moving i root under j root
			parent[irep] = jrep;
			//Increasing result height by 1
			rank[jrep]++;
		}
		
	}

	public static void main(String[] args) {
		// Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointSet dus = new DisjointSet(n);
 
        // 0 is a friend of 2
        dus.union(0, 2);
 
        // 4 is a friend of 2
        dus.union(4, 2);
 
        // 3 is a friend of 1
        dus.union(3, 1);
 
        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

	}

}
