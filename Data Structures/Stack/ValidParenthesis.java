package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char popped = stack.pop();
                if((c == ')' && popped != '(') || (c == '}' && popped != '{') || (c == ']' && popped != '[')) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("[{()}]"));
        System.out.println(isValid("[{)}]"));
        System.out.println(isValid("[{)(}]"));
        System.out.println(isValid("[}"));
        System.out.println(isValid("((("));
    }
}
