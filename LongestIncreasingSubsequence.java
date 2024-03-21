package dsaProblems;

import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {3,5,-1,0,6,2,3};
		System.out.println(lengthOfLIS(7, arr));
	}
	
	//Function to find length of longest increasing subsequence.
    static int longestSubsequenceNaive(int size, int a[])
    {
        //Initialize dp array
        int[] dp = new int[size];
        Arrays.fill(dp,1);
        int length = 1;
        
        //Fill dp array
        for(int i = 1; i<size; i++) {
        	for(int j = 0; j<i; j++) {
        		if(a[i]>a[j] && (dp[j]+1 >dp[i])) {
        				dp[i] = dp[j]+1;
        		}
        	}
        	//Find max length till i position
        	if(dp[i]>length)
        		length = dp[i];
        }
        
        return length;
    }
    
    static int lengthOfLIS(int n,int[] nums) {
    	List<Integer> lis = new ArrayList<>();
    	lis.add(nums[0]);
    	for(int i=1; i<n; i++) {
    		if(nums[i]>lis.get(lis.size()-1)) {
    			lis.add(nums[i]);
    		}else {
    			int point = Collections.binarySearch(lis, nums[i]);
    			if(point<0) {
    				point = -(point+1);
    			}
    			lis.set(point, nums[i]);
    		}
    	}
    	return lis.size();
    }


}
