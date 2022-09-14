package No64;

/**
 * @author ChrisPeng
 * @date 9/5/2022 7:21 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 3, 1},{1, 5, 1}, {4, 2, 1}};
        int i = solution.minPathSum(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]表示的是到当前节点需要的最短的和
        int[][] dp = new int[m][n];
        //首先进行初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
