package TwoPointers;

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

        test(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
        test(new int[]{4,2,0,3,2,5}, 9);
        test(new int[]{3,0,2,0,4}, 7);
        test(new int[]{2,0,2}, 2);
        test(new int[]{1,2,3,4,5}, 0);
        test(new int[]{5,4,3,2,1}, 0);
        test(new int[]{5}, 0);
        test(new int[]{5,0,5}, 5);

    }

    private static void test(int[] arr, int expected) {

        int result = maxWater(arr);

        System.out.println("Input:    " + Arrays.toString(arr));
        System.out.println("Output:   " + result);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    //Two-pointer approach
    private static int maxWater(int[] arr) {
        int n = arr.length;
        if(n<3) return 0;
        int l=0, r=n-1;
        int leftMax = 0, rightMax = 0;
        int count = 0;
        while(l<r) {
            leftMax = Math.max(arr[l],leftMax);
            rightMax = Math.max(arr[r],rightMax);
            if(leftMax<rightMax) {
                count += leftMax - arr[l];
                l++;
            } else {
                count += rightMax - arr[r];
                r--;
            }
        }
        return count;
    }

    //DP or Pre-sum approach
    private static int maxWater1(int[] arr) {
        int n = arr.length;
        if(n<3) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];
        //calculate left max at each index
        for(int i=1;i<n;i++)
            leftMax[i] = Math.max(arr[i],leftMax[i-1]);

        //calculate right max at each index
        for(int i=n-2;i>=0;i--)
            rightMax[i] = Math.max(arr[i],rightMax[i+1]);

        int count = 0;
        for(int i=0;i<n;i++)
            count += Math.max(0,Math.min(leftMax[i],rightMax[i])-arr[i]);

        return count;
    }
}
