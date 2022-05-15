package LeetCode_DP.No746;

/**
 * @author ChrisPeng
 * @date 2022/4/26 10:25
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10,15,20};
        int i = solution.minCostClimbingStairs(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //cost[i]表示从第i个台阶向上爬需要支付的费用，支付后可以往上爬一个或者两个台阶
        //可以选择从下标0或者下标1开始爬
        int len = cost.length;
        if (len == 2)
            return Math.min(cost[0],cost[1]);
        int[] dp = new int[len + 1];//dp[i]为到达i的花费
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
