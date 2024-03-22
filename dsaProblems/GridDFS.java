package dsaProblems;

public class GridDFS {
	static int m,n;

	public static void main(String[] args) {
		// Given matrix
	    int[][] grid = { { 1, 2, 3, 4 },
	                    { 5, 6, 7, 8 },
	                    { 9, 10, 11, 12 },
	                    { 13, 14, 15, 16 } };
	    printDfs(grid);

	}

	static void printDfs(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int[][] viz = new int[m][n];
		dfs(grid,0,0,viz);
	}

	static void dfs(int[][] grid, int i, int j, int[][] viz) {
		System.out.print(grid[i][j]+" ");
		viz[i][j] = 1;
		//Move Up
		if(isValid(i-1,j,viz))
			dfs(grid,i-1,j,viz);
		//Move left
		if(isValid(i,j-1,viz))
			dfs(grid,i,j-1,viz);
		//Move right
		if(isValid(i,j+1,viz))
			dfs(grid,i,j+1,viz);
		//Move down
		if(isValid(i+1,j,viz))
			dfs(grid,i+1,j,viz);
		
	}

	static boolean isValid(int i, int j, int[][] viz) {
		//Check if coordinates are valid
		if(i>=0 && i<m && j>=0 && j<n && viz[i][j]==0)
			return true;
		
		return false;
	}

}
