package LeetCode_DP.No718;

/**
 * @author ChrisPeng
 * @date 2022/5/19 15:03
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]表示下标i-1为结尾的A以及下标j-1为结尾的B，最长的重复子数组长度为dp[i][j]
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}