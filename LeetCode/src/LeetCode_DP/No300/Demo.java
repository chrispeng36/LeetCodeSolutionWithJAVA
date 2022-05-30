package LeetCode_DP.No300;

/**
 * @author ChrisPeng
 * @date 2022/5/18 21:05
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        //给定一个整数数组nums，找到其中最长严格递增子序列的长度
        //dp数组表示的意思是：表示i之前包括i结尾最长上升子序列的长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;//初始化全部为1，再不济都有1
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}