package SlidingWindow;

public class CountSubarraysWithExactKSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int k = 2;
        System.out.println(countBinarySubarray(nums, k)); // Expected 4
    }

    private static int countBinarySubarray(int[] nums, int k) {
        return countAtMost(nums,k) - countAtMost(nums,k-1);
    }

    private static int countAtMost(int[] nums, int k) {
        if(k < 0) return 0;
        int count = 0;
        int sum = 0;
        for(int i=0, j=0; j<nums.length; j++) {
            sum += nums[j];
            while(sum > k) {
                sum -= nums[i];
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }
}
