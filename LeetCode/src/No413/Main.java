package No413;

/**
 * @author ChrisPeng
 * @date 9/15/2022 8:45 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,4};
        int i = solution.numberOfArithmeticSlices(arr);
        System.out.println(i);
    }
}

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return 0;
        /**
         * dp[i]表示的是第i个数字结尾的，且长度大于等于3的连续等差数列的个数
         * 但是会有break point
         *
         **/
        int[] dp = new int[len];
        dp[0] = 0;dp[1] = 0;
        int res = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}