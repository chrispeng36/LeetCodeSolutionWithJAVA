package No813;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/11/28 9:19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        double v = solution.largestSumOfAverages(arr, 4);
        System.out.println(v);
    }
}

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        /**
         * 给定数组nums和一个整数k
         * 将给定的数组nums分为最多k个相邻的非空子数组
         * 分数由子数组内的平均值的总和构成
         * 返回最大能得到的分数
         */

        /**
         * dp[i][k]表示前i个数构成k个子数组时的最大平均值，那么对于所有的0 <= j <= i - 1
         * j表示nums在区间[0, i - 1]被切分为j个子数组的最大平均值和
         * dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (A[j + 1] + ... + A[i + 1]) / (i - j))
         */
        double[][] dp = new double[nums.length + 1][k + 1];
        //额外记录一个sum数组保存到前i个数的和，便于计算(A[j + 1] + ... + A[i + 1]) / (i - j)
        double[] sum = new double[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[i][1] = sum[i] / i;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (sum[i] - sum[l]) / (i - l));
                }
            }
        }
        return dp[nums.length][k];
    }
}