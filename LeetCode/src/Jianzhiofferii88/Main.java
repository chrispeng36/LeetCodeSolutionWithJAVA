package Jianzhiofferii88;

/**
 * @author ChrisPeng
 * @date 9/6/2022 11:20 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = solution.minCostClimbingStairs(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        int[] dp1 = new int[n + 1];
        dp1[0] = 0;
        dp1[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            dp1[i] = Math.min(dp1[i - 1] + cost[i - 1], dp1[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[n], dp1[n]);
    }
}
