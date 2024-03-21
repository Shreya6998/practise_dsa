package dsaProblems;
public class LargestSubsquare {

	public static void main(String[] args) {
		int n = 6;
		char mat[][] = { { 'X', 'X', 'X', 'X', 'X', 'X' },
						 { 'X', 'X', 'X', 'O', 'O', 'X' },
						 { 'X', 'X', 'X', 'O', 'O', 'X' },
						 { 'X', 'X', 'X', 'X', 'X', 'X' },
						 { 'X', 'X', 'X', 'X', 'X', 'X' },
						 { 'X', 'X', 'X', 'X', 'X', 'X' } };
        System.out.println(largestSubsquare(n , mat));
	}
    static int largestSubsquare(int n, char a[][]) {
        // code here
    	int maxCount = 0;
    	int[][][] count = new int[n][n][2];
    	//Form count matrix
    	for(int i = 0; i<n ; i++) {
    		int hor = 0;
        	int  ver = 0;
    		for(int j = 0; j<n ; j++) {
    			if(a[i][j] == 'X') {
        			hor++;
        		}else {
        			hor = 0;
        		}
        		if(a[j][i] == 'X') {
        			ver++;
        		}else {
        			ver = 0;
        		}
        		count[i][j][0] = hor;
        		count[j][i][1] = ver;
        	}
    	}
//    	//Print count matrix
//    	for(int i = 0; i<n ; i++) {
//    		for(int j = 0; j<n ; j++) {
//    			System.out.print("("+count[i][j][0]+","+count[i][j][1]+")");
//    		}
//    		System.out.println();
//    	}
    	//Traverse count matrix
    	for(int i = n-1; i>=0 ; i--) {
    		for(int j = n-1; j>=0 ; j--) {
    			int min = Math.min(count[i][j][0],count[i][j][1]);
    			while(min > maxCount) {
    				if(count[i-min+1][j][0] >= min && count[i][j-min+1][1] >= min) {
    					maxCount = min;
    					break;
    				}
    				min--;
    			}
    		}
    	}

    	return maxCount;
    }

}
