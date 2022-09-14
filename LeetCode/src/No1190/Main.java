package No1190;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/8/24 16:32
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseParentheses("(abed)");
        System.out.println(s);
    }
}

class Solution {
    public String reverseParentheses(String s) {
        //从括号由内到外的顺序，逐层反转每对匹配括号中的字符串
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')//栈里面记录的是左括号的位置
                stack.push(i);
            if (arr[i] == ')')//遇到右括号的时候，那就找到其匹配的左括号，反转中间的字符串
                reverse(arr, stack.pop() + 1, i - 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ')' && arr[i] != '(')
                sb.append(arr[i]);
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int left, int right){
        while (right > left){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right --;
            left ++;
        }
    }
}
