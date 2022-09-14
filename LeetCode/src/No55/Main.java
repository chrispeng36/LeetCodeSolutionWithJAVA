package No55;

/**
 * @author ChrisPeng
 * @date 9/8/2022 3:19 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        /**
         * 先来看看dp的做法
         */
//        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
////        for (int i = 1; i < nums.length; i++) {
////            dp[i] = false;
////        }
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (dp[j] && nums[j] + j >= i){
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[nums.length - 1];

        /**
         * 再来看看贪心的思路
         */
        if (nums.length <= 1)
            return true;
        int nextReach = 0;
//        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            if (i <= nextReach){//当前的阶数不能大于最远能到达的
                nextReach = Math.max(i + nums[i], nextReach);
                if (nextReach >= nums.length - 1)
                    return true;
            }
        }
        return false;
    }
}