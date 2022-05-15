package No150;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author ChrisPeng
 * @date 2022/4/9 16:22
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"4","13","5","/","+"};
        int i = solution.evalRPN(arr);
        System.out.println(i);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
//        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")))
                stk.push(Integer.parseInt(s));
            else {
                int b = stk.pop();
                int a = stk.pop();
                int tempRes = cal(tokens[i], a, b);
                stk.push(tempRes);
            }
        }
        return stk.pop();
    }

    private int cal(String s, int a, int b){
        if (s.equals("+"))
            return a + b;
        else if (s.equals("-"))
            return a - b;
        else if (s.equals("*"))
            return a * b;
        else
            return a / b;
    }
}
