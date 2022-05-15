package No1047;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/4/2 9:55
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.removeDuplicates("abbaca");
        System.out.println(res);
    }
}

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else {
                if (stack.peek() == s.charAt(i))
                    stack.pop();//与栈顶元素相同就弹出
                else
                    stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        //最后留在栈中的元素就是剩余的元素
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}