//package No1262;
//
///**
// * @author ChrisPeng
// * @date 2021/10/13 13:43
// */
//public class Demo {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Solution {
//    public int maxSumDivThree(int[] nums) {
//        int[] dp = new int[3];
//        dp[nums[0] % 3] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int[] temp = new int[3];
//            for (int k = 0; k < 3; k++)
//                temp[k] = dp[k];
//            for (int j = 0; j < 3; j++) {
//                int index = (temp[j] + nums[i]) % 3;
//                dp[index] = Math.max(dp[index], temp[j] + nums[i]);
//            }
//        }
//        return dp[0];
//    }
//}
