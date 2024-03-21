package dsaProblems;

public class CountOneThreeFour {

	public static void main(String[] args) {
		int N = 5;
		System.out.println(countWays(N));
	}

	static int countWays(int n) {
		if(n==0 || n==1 ||n==2)
			return 1;
		if(n==3)
			return 2;
		
		int dp_i = 0,dp_i_1,dp_i_2,dp_i_3,dp_i_4;
		dp_i_2 = dp_i_3 = dp_i_4 = 1;
		dp_i_1 = 2;
		for(int i=4;i<=n;i++) {
			dp_i = dp_i_1 + dp_i_3 + dp_i_4;
			dp_i_4 = dp_i_3;
			dp_i_3 = dp_i_2;
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		
		return dp_i;
	}

}
