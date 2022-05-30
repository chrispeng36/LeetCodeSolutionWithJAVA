package LeetCode_DP.No309;

/**
 * @author ChrisPeng
 * @date 2022/5/16 17:15
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        /**
         * dp[i][j]表示第i天的状态为j，所剩的最多现金为dp[i][j]
         * 状态1：买入股票状态，今天买入股票，或者是之前就买入了然后没有操作
         * 状态2：前两天就卖出了股票，度过了冷冻期但是没有操作，今天保持卖出股票的状态
         * 状态3：今天卖出了股票
         * 状态4：今天为冷冻期状态，但冷冻期不可持续，只有1天
         * 1. dp[i][0] = dp[i - 1][0]
         * 2.
         */
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
