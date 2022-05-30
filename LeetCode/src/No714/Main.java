package No714;

/**
 * @author ChrisPeng
 * @date 2022/5/18 15:53
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        /**
         * prices表示第i天的股票价格
         * fee表示交易股票的手续费
         * 可以无限次交易股票，每笔都要手续费，
         * 如果购买一个股票，出售之前不能购买
         */

        /**
         * dp[i][0]表示第i天持有股票所节省最多现金，dp[i][1]表示第i天不持有股票所得的最多的现金
         * dp[i][0] = max(dp[i - 1][0],dp[i-1][1] - prices[i]);
         * dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
         */

        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = - prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}