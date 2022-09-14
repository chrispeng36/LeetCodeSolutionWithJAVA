package WeekendContests.No308.No6161;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 8/28/2022 10:59 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*'){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}