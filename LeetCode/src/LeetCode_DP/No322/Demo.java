package LeetCode_DP.No322;

/**
 * @author ChrisPeng
 * @date 2022/5/8 10:49
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,5};
        int i = solution.coinChange(arr, 11);
        System.out.println(i);
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        //给定一个整数数组coins，表示不同面额的硬币
        //一个总金额account
        //计算并返回可以凑成总金额的最少的硬币个数
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {//遍历物品
            for (int j = coins[i]; j <= amount; j++) {//遍历背包，背包容量肯定要大于物品重量
                if (dp[j - coins[i]] != max)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}