package dsaProblems;

import java.util.*;
public class UnionFindAlgorithm {
	int[] parent,size;
	int n;

	public static void main(String[] args) {
		UnionFindAlgorithm obj = new UnionFindAlgorithm();
		int n = 3;
		int[][] edges = {{1, 2, 1}, {2, 3, 4}};
		int q = 1;
		int[] queries = {3};
		ArrayList<Integer> ans = obj.maximumWeight(n, edges, q, queries); 
        for (Integer val: ans) 
            System.out.print(val+" "); 
        System.out.println();
	}
	
	public void makeSet(int n) {
		parent = new int[n];
		size = new int[n];
		this.n = n;

		//Assign each element as its own parent
		for(int i=0; i<n ; i++) {
			this.parent[i] = i;
		}
		Arrays.fill(size, 1);
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
	
	//Union by Size
	public int union(int i, int j) {
		int irep = find(i), jrep = find(j);
		int result = size[jrep] * size[irep];
		
		if(size[jrep] < size[irep]) {
			//Moving j root under i root
			parent[jrep] = irep;
			//Sum to get result size
			size[irep] += size[jrep];
		
		}else {
			//Moving i root under j root
			parent[irep] = jrep;
			//Sum to get result size
			size[jrep] += size[irep];
		}
		return result;
		
	}
		
	ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
		ArrayList<Integer> result = new ArrayList<>();

		//If given n edges, n+1 nodes are present
		UnionFindAlgorithm ds = new UnionFindAlgorithm();
		ds.makeSet(n+1);

		//To store the possible paths for given queries
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		//Defined this to store the result of previous query
		int prev = 0;

		//Sort the given edges by weight
		Arrays.sort(edges, (a,b)->Integer.compare(a[2], b[2]));

		//Iterate through all the edges and calculate the possible path count  
		for(int i = 0; i<n-1; i++) {
			prev = prev + ds.union(edges[i][0],edges[i][1]);
			map.put(edges[i][2], prev);
		}
		
		//Iterate through the queries
		for(int i = 0; i<q; i++) {
			Integer pathcount = 0;
			for(Map.Entry<Integer, Integer> w:map.entrySet()) {
				if(w.getKey() <= queries[i])
					pathcount = w.getValue();
			}
			result.add(pathcount);
		}

		return result;
    }

}
