package WeekendContests.No310.No6206;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/11/2022 11:16 AM
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {4,2,1,4,3,4,5,8,15};
        Solution solution = new Solution();
        int i = solution.lengthOfLIS(arr, 3);
        System.out.println(i);
    }
}

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
//        if (nums.length == 1)
//            return 1;
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//        int res = 0;
//        /**
//         * dp[i]表示的是i处的最长递增子序列的长度
//         * dp[i] =
//         */
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j] && nums[i] - nums[j] <= k)
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                res = Math.max(res, dp[i]);
//            }
//        }
//        return res;
        //每个元素 tails[k] 的值代表 长度为 k+1 的子序列尾部元素的值
        /**
         * 区间中存在tails[i] > nums[k]：将第一个满足tails[i] > nums[k]执行tails[i] = nums[k]
         * 区间中不存在tails[i] > nums[k]
         */
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j){
                int m = (i + j) / 2;
                if (tails[m] < num && num - tails[m] <= k){
                    i = m + 1;
                }else if (tails[m] >= num){
                    j = m;
                }else {
                    i ++;
                }
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}