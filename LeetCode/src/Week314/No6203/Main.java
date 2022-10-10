package Week314.No6203;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 2022/10/9 11:30
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        int i = solution.numberOfPaths(arr, 3);
        System.out.println(i);
    }
}

class Solution {
    final int mod = (int) 1e9 + 7;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        /**f[i, j, v]表示从左上角走到(i, j)且路径和模k结果是v时的路径数**/
        int[][][] f = new int[m + 1][n + 1][k];
        f[0][1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int v = 0; v < k; v++) {
                    f[i + 1][j + 1][(v + grid[i][j]) % k] = ((f[i + 1][j + 1][(v + grid[i][j]) % k] + f[i + 1][j][v]) % mod + f[i][j + 1][v]) % mod;
                }
            }
        }
        return f[m][n][0];
    }
}
