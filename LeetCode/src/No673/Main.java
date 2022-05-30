package No673;

/**
 * @author ChrisPeng
 * @date 2022/5/23 10:11
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        /**
         * 维护挎包房费时更要注意
         * dp[i]：i之前包括i的最长递增子序列的长度
         * count[i]：以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]
         * 首先更新dp[i]：
         * if (nums[i] > nums[j])
         *      dp[i] = max(dp[i], dp[j] + 1);
         * 更新count[i]
         * 在nums[i] > nums[j]的条件下，如果在[0, i - 1]的范围内找到了j，使得dp[j] + 1 > dp[i]，
         * 说明找到了一个更长的递增子序列
         * 那么以j为结尾的子串的最长递增子序列的个数，就是最新的以i为结尾的子串的最长递增子序列的个数
         * 即：count[i] = count[j]
         * 在nums[i] > nums[j]的条件下如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 == dp[i]，说明找到了两个相同长度的递增子序列。
         *
         * 那么以i为结尾的子串的最长递增子序列的个数 就应该加上以j为结尾的子串的最长递增子序列的个数，
         * 即：count[i] += count[j];
         */
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int[] count = new int[nums.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if (dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) maxCount = dp[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) result += count[i];
        }
        return result;
    }
}