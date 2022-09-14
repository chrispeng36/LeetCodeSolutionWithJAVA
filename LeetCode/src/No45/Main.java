package No45;

/**
 * @author ChrisPeng
 * @date 9/7/2022 3:12 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 0, 1, 4};
        int i = solution.jump(arr);
        System.out.println(i);
    }
}

class Solution {
    public int jump(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        for (int i = 1; i < len; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//        dp[0] = 0;
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] + j >= i){
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[len - 1];
        if (nums.length == 1)
            return 0;
        int reach = 0;
        int nextReach = nums[0];
        int step = 0;//需要的跳数
        for (int i = 0; i < nums.length; i++) {
            nextReach = Math.max(i + nums[i], nextReach);//i + nums[i]表示当前台阶能够跳到的最远
            if (nextReach >= nums.length - 1)//如果大于的话直接就返回了
                return step + 1;
            if (i == reach){//遍历的地点刚好等于到达的地点
                step ++;//需要的阶数加一
                reach = nextReach;//跳到下一个
            }
        }
        return step;
    }
}