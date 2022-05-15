package No20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/3/31 19:01
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("(([]){})");
        System.out.println(valid);
    }
}

class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(')
                deque.push(')');
            else if (ch == '{')
                deque.push('}');
            else if (ch == '[')
                deque.push(']');
            else if (deque.isEmpty() || deque.peek() != ch)
                return false;
            else
                deque.pop();
        }
        return deque.isEmpty();
    }
}