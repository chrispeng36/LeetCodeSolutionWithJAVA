package LeetCode_DP.No583;

/**
 * @author ChrisPeng
 * @date 2022/5/27 9:22
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        /**每一步可以删除任意一个字符串中的任意一个字符**/
        /**只需要先求出两个字符串的最长公共子序列的长度，
         * 那么除了最长公共子序列之外的字符都是必须删除的
         * 最后用两个字符串的总长度减去两个最长公共子序列的长度就是删除的最少步数
         * **/
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}