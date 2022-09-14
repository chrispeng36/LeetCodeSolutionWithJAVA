package No152;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/13/2022 8:13 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        int i = solution.maxProduct(nums);
        System.out.println(i);
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        /**
         * 找到数组中乘积最大的非空连续子数组
         * dp[i] = max(dp[i - 1], dp[i - 1] * )
         */
        int[] dp = new int[nums.length];
        int[] minimal = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], Math.max(nums[i], minimal[i - 1] * nums[i]));
            minimal[i] = Math.min(minimal[i - 1] * nums[i], Math.min(nums[i],dp[i - 1] * nums[i]));
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}