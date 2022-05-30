package LeetCode_DP.No115;

/**
 * @author ChrisPeng
 * @date 2022/5/26 10:28
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numDistinct(String s, String t) {
        //给定一个字符串s和一个字符串t，计算s的子序列在t中出现的个数
        /**
         * dp[i][j]表示以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为ddp[i][j]
         * 当s[i-1]与t[i-1]相等时，dp[i][j]可以由两部分组成
         * 一部分是s[i-1]来匹配，那么个数是dp[i-1][j-1]
         * 一部分是不用s[i-1]来匹配，个数为dp[i-1][j]
         * 当s[i-1]和t[j-1]相等时，dp[i][j]=dp[i - 1][j - 1] + dp[i - 1][j]
         * 当s[i - 1]与t[j - 1]不相等时，dp[i][j]只有一部分组成，不用s[i - 1]来匹配，即dp[i - 1][j]
         */
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}