package LeetCode_DP.No213;

/**
 * @author ChrisPeng
 * @date 2022/5/10 20:44
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,1};
        int rob = solution.rob(arr);
        System.out.println(rob);
    }
}

class Solution {
    public int rob(int[] nums) {
        int no_start = myRob(nums, 1, nums.length - 1);
        int no_end = myRob(nums, 0, nums.length - 2);
        return Math.max(no_end,no_start);
    }

    private int myRob(int[] nums, int left, int right){
        //这里的情况能保障right-left > 1
        int[] dp = new int[right - left + 1];
        /**这里有一个变化的关系，left->0,
         * 也就是nums的i要比dp大left
         * **/
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i <= right - left; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[left + i]);
        }
        return dp[right - left];
    }
}