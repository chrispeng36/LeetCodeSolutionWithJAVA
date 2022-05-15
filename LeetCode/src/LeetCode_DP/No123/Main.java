package LeetCode_DP.No123;

/**
 * @author ChrisPeng
 * @date 2022/5/14 14:19
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 给定一个数组，它的第i个元素是一只股票在第i天的价格
         * 求能获取的最大的利润，最多可以完成两笔交易
         * 不能同时参与多个交易，必须在再次购买之前出售
         */
        /**
         * 二维dp数组，dp[i][j]中的i表示第i天，j为[0-4]五个状态
         * dp[i][j]表示第i天状态j所剩最大的现金
         *
         *
         */
        int len = prices.length;
        if (prices.length == 0) return 0;

        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
        }

        return dp[len - 1][4];
    }
}