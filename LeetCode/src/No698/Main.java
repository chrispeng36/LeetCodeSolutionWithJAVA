package No698;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/1/2022 9:36 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0)
            return false;
        if (k == 1)
            return true;
        Arrays.sort(nums);//先排序
        int target = sum / k;
        int len = nums.length;
        if (nums[len - 1] > target)
            return false;
        int size = 1 << len;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            if (! dp[i])//基于dp[i] = true的前提下进行状态转移
                continue;
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0)
                    continue;
                int next = i | (1 << j);
                if (dp[next])
                    continue;
                if ((currentSum[i] % target) + nums[j] <= target){
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                }else {
                    // 由于数组已经排好序，如果 (currentSum[i] % target) + nums[j] > target，剩下的数就没有必要枚举
                    break;
                }
            }
        }
        return dp[size - 1];
    }
}