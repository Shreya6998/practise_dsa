package Stack;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3, 10, 8};

        int[] result = nextGreaterElement(arr);

        System.out.println(Arrays.toString(result));
    }

    private static int[] nextGreaterElement(int[] arr) {
        if(arr.length == 0) return arr;

        // Create default array
        int[] output = new int[arr.length];
        for(int i=0; i< arr.length; i++) {
            output[i] = -1;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        // Traverse the input array
        for(int i=1; i< arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                output[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return output;
    }
}
