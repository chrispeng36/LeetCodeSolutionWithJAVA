package LeetCode_DP.No72;

/**
 * @author ChrisPeng
 * @date 2022/5/29 12:18
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        /**
         * 对一个单词可以进行：
         * 插入
         * 删除
         * 替换
         */

        /**
         * 这种编辑距离的问题一般用动态规划求解
         * dp[i][j]表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2最近编辑距离为dp[i][j]
         * 如果word1[i - 1] == word2[i - 1]，那么说明不需要任何的编辑，那么dp[i][j] = dp[i - 1][j - 1]
         * 如果不相等的话，那么就需要编辑了
         * 操作一：word1删除一个元素，那么就是以下标i-2为结尾的word1与j-1为结尾的word2的最近编辑距离再加上上一个操作
         * dp[i][j] = dp[i - 1][j] + 1;
         * 操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
         * dp[i][j] = dp[i][j - 1] + 1;
         * 操作三：替换元素，word1替换word1[i - 1]使其与word2[j - 1]相同，此时不用添加元素，那么以下标i-2
         * 为结尾的word1与j-2为结尾的word2最近编辑距离，加上一个替换的操作
         * dp[i][j] = dp[i - 1][j - 1] + 1;
         */
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;//空字符串变为另外一个当然要加i个
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //因为dp数组有效位从1开始
                //所以当前遍历到的字符串位置为i - 1 / j - 1
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[m][n];
    }
}
