package No739;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/6/1 13:53
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] ints = solution.dailyTemperatures(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();//创建单调栈
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {//遍历数组所有元素
            /**
             * //当数组中的元素大于栈顶元素，说明找到了大于栈顶元素的第一个元素，
             * 此时栈顶元素抛弃，因为这个点已经找到了比它大的第一个元素
             * 把当前元素压入，需要剔除的是栈内所有的小于当前元素的值，并维持一个单调递增栈
             *
             */
            while (! stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int peak = stack.pop();
                ans[peak] = i - peak;
            }
            stack.push(i);
        }
        return ans;//无论如何都会存在一个压栈的操作
    }
}
