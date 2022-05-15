package No63;

/**
 * @author ChrisPeng
 * @date 2022/4/28 14:32
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,0,0},{0,1,0}};
        int i = solution.uniquePathsWithObstacles(arr);
        System.out.println(i);
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //网格中的1表示障碍物，0表示没有障碍物的地方
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;//遇到障碍，后序都到不了
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
