package No503;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/6/2 10:50
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,1};
        int[] ints = solution.nextGreaterElements(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //给定一个循环数组nums，返回nums中每个元素的下一个更大的元素
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < 2 * n; i++) {
            while (! stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]){
                //如果当前遍历的数字要比栈顶的元素大的话，就弹出栈
                int peek = stack.pop();
                res[peek] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}