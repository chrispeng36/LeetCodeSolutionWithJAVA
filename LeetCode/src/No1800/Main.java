package No1800;

/**
 * @author ChrisPeng
 * @date 2022/10/7 14:44
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 20, 30, 40, 50};
        int i = solution.maxAscendingSum(arr);
        System.out.println(i);
    }
}


class Solution {
    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        //dp[i]表示的是包含i的递增子序列
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }
}