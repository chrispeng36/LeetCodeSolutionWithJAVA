package No907;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 9/14/2022 1:27 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        //处理边界情况
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        //每个元素辐射范围的左右边界
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        //第一次循环先找到所有元素的左边界
        for (int i = 0; i < n; i++) {
            //向左找第一个小于等于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            //设置一个最左边界-1
            if (stack.isEmpty()){
                left[i] = -1;
            }else {
                left[i] = stack.peek();
            }
            //下标入栈,方便同时得到i和A[i]
            stack.push(i);
        }
        //第二次循环找到所有元素的右边界
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            //向右找到第一个小于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            //设立一个最右边界n
            if (stack.isEmpty()){
                right[i] = n;
            }else {
                right[i] = stack.peek();
            }
            //下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }
        //元素A[i]的贡献值为A[i] * (i - left) * (right - i + 1)
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }
}