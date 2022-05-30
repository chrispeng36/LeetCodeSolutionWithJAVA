package LeetCode_DP.No1035;

/**
 * @author ChrisPeng
 * @date 2022/5/23 21:13
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        /**
         * 直线不能相交，这就是说明：
         * 在字符串A中找到一个与字符串B相同的子序列
         * 且这个子序列不能改变相对顺序，只要相对顺序不变
         * 链接相同数字的直线就不会相交
         * 那么这个题目也就是求出两个字符串的最长公共子序列的长度
         */
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[nums1.length][nums2.length];

    }
}
