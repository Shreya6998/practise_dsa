package dsaProblems;

public class MaximalSquare {

	public static void main(String[] args) {
//		int[][] in = {{0,1,1,1,1,1,1,0,1,1},
//						{1,1,1,1,1,1,1,1,1,0},
//						{1,1,1,0,1,0,1,1,1,1},
//						{1,1,1,1,1,1,1,1,1,0},
//						{1,1,1,0,1,1,1,1,1,1},
//						{0,0,0,1,1,1,1,1,1,1},
//						{1,1,1,0,1,1,1,0,0,0},
//						{1,1,0,1,1,1,1,1,0,1},
//						{1,1,1,1,1,1,1,0,0,1},
//						{1,1,1,0,1,1,1,1,1,0}};
//		System.out.println(maxSquare(10,10,in));
		int[][] in2 = {{0,1},{1,0}};
		System.out.println(maxSquare(2, 2,in2));
	}
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        int count[][] = new int[n][m];
        int maxValue = 0;
        //Copy first column
        for(int i = 0; i < n ; i++){
            count[i][0] = mat[i][0];
            maxValue = Math.max(maxValue,count[i][0]);
        }
        //Copy first row
        for(int j = 0; j < m ; j++){
            count[0][j] = mat[0][j];
            maxValue = Math.max(maxValue,count[0][j]);
        }
        //Calculate other positions
        for(int i=1; i<n; i++){
            
            for(int j=1; j<m; j++){
                
                if(mat[i][j]==1){
                    //Check all elements on upper left to find maximum possible square at the given point 
                    count[i][j] = Math.min(count[i-1][j],Math.min(count[i][j-1],count[i-1][j-1])) + 1;
                    
                    //Store max value
                    maxValue = Math.max(maxValue,count[i][j]);
                    
                }else if(mat[i][j]==0){
                    //Assign 0 if value is zero
                    count[i][j] = 0;
                }
            }
        }
        
//        for(int i=0; i<m; i++){
//    		for(int j=0; j<n; j++){
//    			System.out.print(count[i][j]+" ");
//    		}
//    		System.out.println();
//        }
        
        return maxValue;
    }
        
}
