package No188;

/**
 * @author ChrisPeng
 * @date 2022/5/15 14:23
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        /**
         * 给定一个整数数组prices，第i个元素prices[i]是股票在第i天的价格
         * 设计一个算法来计算能获得的最大的利润，最多可以完成k笔交易
         */
        /**
         * 使用二维数组 dp[i][j] ：第i天的状态为j，所剩下的最大现金是dp[i][j]
         *
         * j的状态表示为：
         *
         * 0 表示不操作
         * 1 第一次买入
         * 2 第一次卖出
         * 3 第二次买入
         * 4 第二次卖出
         * .....
         *
         * 偶数表示是卖出，奇数表示的是买入
         * 递推公式：
         * 就是第i天卖出股票了和第i天没有操作的最大值
         * for (int j = 0; j < 2 * k - 1; j += 2) {
         *     dp[i][j + 1] = max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
         *     dp[i][j + 2] = max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
         * }
         *
         * 初始化：
         * for (int j = 1; j < 2 * k; j += 2) {
         *     dp[0][j] = -prices[0];
         * }
         * 就是遍历奇数，是买入，需要付钱
         */

        if (prices.length == 0)
            return 0;

        int len = prices.length;
        int[][] dp = new int[len][k * 2 + 1];

        for (int i = 1; i < k * 2; i += 2) {
            dp[0][i] = - prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k * 2 - 1; j+=2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k * 2];
    }
}