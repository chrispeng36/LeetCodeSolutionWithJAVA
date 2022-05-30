package LeetCode_DP.No674;

/**
 * @author ChrisPeng
 * @date 2022/5/19 0:05
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 0;
        //dp[i]表示i之前包括i结尾的最长上升子序列的长度
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i])
                dp[i + 1] = dp[i] + 1;
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }
}