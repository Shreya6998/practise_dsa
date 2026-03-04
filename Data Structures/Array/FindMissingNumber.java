package Array;

public class FindMissingNumber {
    public static int findMissingNumber1(int[] arr) {
        int n = arr.length;
        long sum = (long) n *(n+1)/2;
        for (int j : arr) {
            sum = sum - j;
        }
        return (int) sum;
    }

    private static int findMissingNumber(int[] arr) {
        int xor = arr.length;
        for(int i=0; i < arr.length; i++) {
            xor = xor ^ i ^ arr[i]; //XOR index and element
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};

        int missing = findMissingNumber(nums);
        System.out.println(missing);
    }
}
