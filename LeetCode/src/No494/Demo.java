package No494;

/**
 * @author ChrisPeng
 * @date 2022/5/4 10:00
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,1,1};
        int i = solution.findTargetSumWays(nums, 3);
        System.out.println(i);
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //给定一个整数数组nums和一个整数target
        /**
         * dp[j]表示的是填满j这么大的容积的包有多少种方法
         * 初始化的话，dp[0]=1
         * 对于01背包问题一维dp的遍历，nums放在外循环，target在内循环，且内循环倒序
         *
         */

        /**
         * 设加法的总和是x，减法的总和就是sum-x
         * 要求x-(sum-x)=target
         * x = (target + sum) / 2,就是要装的背包
         */
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}