package LeetCode_DP.No121;

/**
 * @author ChrisPeng
 * @date 2022/5/12 10:27
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        //prices[i]表示的是一只股票第i天的价格
        /**贪心算法**/
//        int low = Integer.MAX_VALUE;
//        int result = 0;
//        for (int i = 0; i < prices.length; i++) {
//            low = Math.min(low, prices[i]);//取最左的最小价格
//            result = Math.max(result, prices[i] - low);//直接取最大区间利润
//        }
//        return result;
        /**动态规划**/
        if (prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[len][2];
        int result = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        /**
         * 如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
         *
         * 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
         * 第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
         * 那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], -prices[i]);
         *
         * 如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
         *
         * 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
         * 第i天卖出股票，所得现金就是按照今天股票佳价格卖出后所得现金即：prices[i] + dp[i - 1][0]
         * 同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
         */
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][1];
    }
}