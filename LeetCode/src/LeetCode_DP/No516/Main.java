package LeetCode_DP.No516;

/**
 * @author ChrisPeng
 * @date 2022/5/30 13:54
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestPalindromeSubseq("bbbab");
        System.out.println(i);
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        //给定一个字符串，找到其最长回文子串
        /**
         * dp[i][j]表示区间范围[i,j]中的最长回文子串的长度
         * 如果s[i]和s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2
         * 如果s[i]和s[j]不相同，说明s[i]和s[j]的同时加入并不能增加[i,]区间内的回文子串的长度
         * 分别加入s[i]和s[j]看哪一个可以组成最长的回文子序列
         * 加入s[j]的回文子序列长度为dp[i + 1][j]
         * 加入s[i]的回文子序列的长度为dp[i][j-1]
         */
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;//初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
            }
        }
        return dp[0][len - 1];
    }
}
