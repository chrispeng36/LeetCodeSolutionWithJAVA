package No856;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/10/9 9:35
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.scoreOfParentheses("(()(()))");
        System.out.println(i);
    }
}

class Solution {
    public int scoreOfParentheses(String s) {
        //()得一分，A+B得两分，(A)得2*A分
        Stack<Character> stack = new Stack<>();
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                //遇到左括号的时候才压栈
                stack.push(s.charAt(i));
                flag = true;
            }else {
                if (flag){//因为外部的括号只是起到了一种加权的作用
                    res += Math.pow(2, stack.size() - 1);
                    flag = false;
                }
                stack.pop();
            }
        }
        return res;
    }
}
