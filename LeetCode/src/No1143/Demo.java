package No1143;

/**
 * @author ChrisPeng
 * @date 2022/3/28 14:38
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * 找到两个字符串的最长的公共子序列的长度
         * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
         * （也可以不删除任何字符）后组成的新字符串。
         */
        /**
         * 数组dp[i][j]表示text1[0:i]和text2[0,j]的最长公共序列的长度
         * 边界情况：
         * 1. 当i=0，text1[0:i]为空，字符串和任何字符串的最长公共子序列的长度都是0，因此dp[0][j]=0
         * 2. 当j=0，同理dp[i][0]=0
         * 当i>0 and j > 0时，考虑dp[i][j]的计算
         * 1. 当text1[i-1] = text2[j-1]时，此时dp[i][j]=dp[i-1][j-1]+1
         * 2. 当text1[i - 1] ≠ text2[j - 1]时，dp[i][j] = max{dp[i - 1][j], dp[i][j-1]}
         *
         */
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
