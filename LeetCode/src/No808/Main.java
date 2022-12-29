package No808;

import java.util.NavigableMap;

/**
 * @author ChrisPeng
 * @date 2022/11/21 9:24
 */
public class Main {
    public static void main(String[] args) {

    }
}

//class Solution {
//    public double soupServings(int n) {
//        /**
//         * 四种操作为：(4, 0), (3, 1), (2, 2), (1, 3)
//         * 每种操作的概率为0.25
//         * dp[i, j]表示汤A和B分别剩下i和j份时所求的概率值
//         * 即汤 A 先分配完的概率 + 汤 A 和汤 B 同时分配完的概率除以 22
//         * dp(i, j) = 1/4 x (dp(i - 4, y) + dp(i - 3, y - 1) + dp(i - 2, y - 2) + dp(i - 1, y - 3))
//         * 当满足 i > 0,j = 0，此时无法再分配，而汤 A 还未分配完成，汤 A 永远无法完成分配，此时 dp(i, j) = 0；
//         * 当满足 i = 0,j = 0，此时汤 A 和汤 B 同时分配完的概率为 1.0，汤 A 先分配完的概率为 0，因此 dp(i, j) = 1.0 x 0.5 = 0.5；
//         * 当满足 i = 0,j > 0，此时无法再分配，汤 A 先分配完的概率为 1.0，汤 B 永远无法完成分配，因此 dp(i, j) = 1.0；
//         *
//         */
//        n = (int) Math.ceil((double) n / 25);
//        if (n >= 179) {
//            return 1.0;
//        }
//        double[][] dp = new double[n + 1][n + 1];
//        dp[0][0] = 0.5;
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = 1.0;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
//            }
//        }
//        return dp[n][n];
//    }
//}


class Solution {
    private double[][] memo;

    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        memo = new double[n + 1][n + 1];
        return dfs(n, n);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0){
            return 0.5;
        } else if (a <= 0) {
            return 1;
        } else if (b <= 0) {
            return 0;
        }
        if (memo[a][b] == 0) {
            memo[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        }
        return memo[a][b];
    }
}