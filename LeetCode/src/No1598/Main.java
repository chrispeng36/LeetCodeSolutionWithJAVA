package No1598;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 9/9/2022 10:01 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"d1/","d2/","../","d21/","./"};
        int i = solution.minOperations(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")){
                if (! stack.isEmpty())
                    stack.pop();
            }else if (logs[i].equals("./")){
                continue;
            }else {
                stack.push(logs[i]);
            }
        }
        return stack.size();
    }
}