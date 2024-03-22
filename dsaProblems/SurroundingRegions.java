package dsaProblems;

public class SurroundingRegions {
    int m,n;
    int[][] viz;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        viz = new int[m][n]; 

        //Moving over first & last row
        for(int j=0;j<n;j++){
            if(board[0][j] == 'O')
                dfs(board,0,j);
            if(board[m-1][j] == 'O')
                dfs(board,m-1,j);
        }
        //Moving over first & last column
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O')
                dfs(board,i,0);
            if(board[i][n-1] == 'O')
                dfs(board,i,n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                if(board[i][j]=='#')
                    board[i][j] = 'O';
            }
        }

    }

    public void dfs(char[][] board,int i,int j){
        if(board[i][j] == 'O')
            board[i][j] = '#';
        else
            return;
		viz[i][j] = 1;
		//Move Up
		if(isValid(i-1,j))
			dfs(board,i-1,j);
		//Move left
		if(isValid(i,j-1))
			dfs(board,i,j-1);
		//Move right
		if(isValid(i,j+1))
			dfs(board,i,j+1);
		//Move down
		if(isValid(i+1,j))
			dfs(board,i+1,j);
    }

    public boolean isValid(int i, int j) {
		//Check if coordinates are valid
		if(i>0 && i<m-1 && j>0 && j<n-1 && viz[i][j]==0)
			return true;
		
		return false;
	}
    
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},
						 {'X','O','O','X'},
						 {'X','O','O','X'},
						 {'X','O','O','X'},
						 {'X','O','O','X'}};
		int row = board.length;
		int col = board[0].length;
				
		SurroundingRegions obj = new SurroundingRegions();
		obj.solve(board);

		for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
            	System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
	}
}
