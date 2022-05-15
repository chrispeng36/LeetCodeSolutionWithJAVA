package No1049;

/**
 * @author ChrisPeng
 * @date 2022/5/3 11:09
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,7,4,1,8,1};
        int i = solution.lastStoneWeightII(arr);
        System.out.println(i);

    }
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        if (len == 1)
            return stones[0];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        //先遍历物品再遍历背包
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j -stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}