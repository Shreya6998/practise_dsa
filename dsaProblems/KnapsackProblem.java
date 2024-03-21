package dsaProblems;
public class KnapsackProblem {

	public static void main(String[] args) {
		
		int[] w = {4,5,1};
		int[] v = {1,2,3};
		System.out.println(knapSack(4, w, v, 3));
	}

	//Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] capacity = new int[n+1][W+1];
         for(int i=0; i <= n ;i++){
             
             for(int w=0; w <= W ;w++){
                if(w==0 || i==0){
                    capacity[i][w] = 0;
                } else if(wt[i-1] > w){
                    capacity[i][w] = capacity[i-1][w];
                } else{
                    int included = val[i-1] + capacity[i-1][w-wt[i-1]];
                    int notIncluded = capacity[i-1][w];
                    capacity[i][w] = Math.max(included,notIncluded);
                }
             }
         }
         
//         for(int i=0;i<=n;i++){
//             for(int j=0; j<=W; j++){
//                 System.out.print(capacity[i][j]+" ");
//             }
//             System.out.println();
//         }
         
        return capacity[n][W];
    }
    
}
