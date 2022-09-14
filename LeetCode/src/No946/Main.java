package No946;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 8/31/2022 9:23 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (! stack.isEmpty() && stack.peek() == popped[j]){
                j ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}