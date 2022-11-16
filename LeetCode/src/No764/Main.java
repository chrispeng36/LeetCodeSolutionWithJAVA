package No764;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ChrisPeng
 * @date 2022/11/9 10:39
 */
public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 对于每个中心点坐标(i, j)，分别从上下左右四个方向计算从(i, j)开始最长连续1的个数
 * 设dp[i][j][k]表示以(i, j)为起点在方向k上的连续1的最大数目
 *      如果grid[i][j]为0，那么此时该方向的连续1的最大数目为0
 *      如果grid[i][j]为1，那么此时该方向的连续1的最大数目为前一个单元为起点的最大数目加1
 * 假设当前k = 0, 1, 2, 3时，分别表示左右上下，我们可以得到以下的递推公式：
 *      dp[i][j][0] = 0 if grid[i][j] = 0 else = dp[i][j - 1][0] + 1
 *      dp[i][j][1] = 0 if grid[i][j] = 0 else = dp[i][j + 1][1] + 1
 *      dp[i][j][2] = 0 if grid[i][j] = 0 else = dp[i - 1][j][2] + 1
 *      dp[i][j][3] = 0 if grid[i][j] = 0 else = dp[i + 1][j][3] + 1
 * 在实际计算时，我们为了方便计算只用 dp[i][j] 保存四个方向中最小的连续 1 的个数即可。
 */
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<Integer>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }
}