package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    private static int longestConsecutiveSequence(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int maxLength = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        for(int n:nums) {
            // check if start element
            if(!set.contains(n - 1)) {
                int seqLength = 1;
                int next = n + 1;
                while(set.contains(next)) {
                    seqLength++;
                    next++;
                }
                if(seqLength > maxLength)
                    maxLength = seqLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutiveSequence(nums);
        System.out.println(result); // 9

        nums = new int[]{100, 4, 200, 1, 3, 2};
        result = longestConsecutiveSequence(nums);
        System.out.println(result); // 4

        nums = new int[]{100, 102, 104, 106};
        result = longestConsecutiveSequence(nums);
        System.out.println(result); // 1

        nums = new int[]{56};
        result = longestConsecutiveSequence(nums);
        System.out.println(result); // 1
    }
}
