package LeetCode_DP.No518;

/**
 * @author ChrisPeng
 * @date 2022/5/6 14:11
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1,2,5};
        int i = solution.change(5, coins);
        System.out.println(i);
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];//表示凑成dp[i]的钱的方式
        dp[0] = 1;

        int len = coins.length;
        for (int i = 0; i < len; i++) {//先遍历物品
            for (int j = coins[i]; j <= amount; j++) {//遍历背包容量，背包的容量肯定要比当前的物品大
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}