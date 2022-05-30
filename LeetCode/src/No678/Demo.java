package No678;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/5/27 16:56
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkValidString("(");
        System.out.println(b);
    }
}

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left.push(i);
            else if (s.charAt(i) == '*') star.push(i);
            else {//遇到了右括号，首先考虑消除左括号，其次考虑消除star
                if (left.isEmpty() && star.isEmpty()) return false;
                if (! left.isEmpty()) left.pop();
                else star.pop();
            }
        }

        while (( ! left.isEmpty()) && (!star.isEmpty())){
            if (left.peek() > star.peek()) return false;
            left.pop();
            star.pop();
        }
        return left.isEmpty();
    }
}