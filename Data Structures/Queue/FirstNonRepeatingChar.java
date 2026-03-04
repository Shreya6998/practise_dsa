package Queue;

import java.util.*;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        char[] stream = {'a', 'b', 'c', 'b', 'a'};

        char[] result = firstNonRepeating(stream);

        System.out.println(Arrays.toString(result));
    }

    private static char[] firstNonRepeating(char[] stream) {
        if (stream.length <= 1) return stream;

        int[] freq = new int[26];
        Queue<Character> queue = new ArrayDeque<>();
        char[] output = new char[stream.length];
        int i = 0;
        for(char ch:stream) {
            freq[ch - 'a']++;
            queue.offer(ch);
            while(!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            char result = queue.isEmpty() ? '#' : queue.peek();
            output[i++] = result;
        }
        return output;
    }
}

