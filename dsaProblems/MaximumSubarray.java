class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,-4};
        int result = maxSubarraySum(arr);
        System.out.println(result);
    }

//    static int maxSubarraySum(int[] arr) {
//        int maxSum = arr[0]; // considering first element as maxSum
//        int length = arr.length;
//        for(int i = 1; i <= length ; i++)
//        {
//            for(int j = 0; j <= length-i; j++)
//            {
//                int currSum = 0;
//                for(int k = j; k < (i+j); k++)
//                {
//                    currSum = currSum + arr[k];
//                }
//                if(currSum > maxSum){
//                    maxSum = currSum;
//                }
//            }
//        }
//        return maxSum;
//    }

        static int maxSubarraySum(int[] arr) {
            int maxSum = 0;
            int result = Integer.MIN_VALUE;
            for (int j : arr) {
                maxSum = Math.max(j, (maxSum + j));
                result = Math.max(result, maxSum);
            }
            return result;
        }

}