import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {
        int sum = sum(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        System.out.println(sum);
        int count = count(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        System.out.println(count);
        int max = max(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(max);
    }

    private static int sum(List<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        return arr.removeFirst() + sum(arr);
    }

    private static int count(List<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        arr.removeFirst();
        return 1 + count(arr);
    }

    private static int max(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr.getFirst();
        }

        return Integer.max(arr.removeFirst(), max(arr));
    }
}
