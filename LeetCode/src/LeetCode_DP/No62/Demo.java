package LeetCode_DP.No62;

/**
 * @author ChrisPeng
 * @date 2022/4/27 15:20
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.uniquePaths(3, 7);
        System.out.println(i);
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
