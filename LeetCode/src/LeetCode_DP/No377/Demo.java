package LeetCode_DP.No377;

/**
 * @author ChrisPeng
 * @date 2022/5/7 12:43
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        int i = solution.combinationSum4(arr, 4);
        System.out.println(i);
    }
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        /**
         * 由不同整数组成的数组nums，和一个目标整数target
         * 从nums中找出并返回总和为target的组合的个数
         */
        //完全背包的问题
        /**
         * 因为这里要考虑顺序，所以先遍历背包，再考虑物品
         * 不然dp[4]只会出现{1,3}而不会出现{3,1}
         */
        int[] dp = new int[target + 1];
        dp[0] = 1;//初始化
        int len = nums.length;
        for (int i = 0; i <= target; i++) {//遍历背包
            for (int j = 0; j < len; j++) {//遍历物品
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
