package No416;

/**
 * @author ChrisPeng
 * @date 2022/5/2 13:05
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        //判断一个数组是否可以被划分为两个子集，使得两个子集的元素之和相等
        /**
         * 背包的体积为sum / 2
         * 背包放入的商品（集合里面的元素）重量为元素的数值，价值也为元素的数值
         * 背包如果正好装满，那么找到了
         * 背包中的每个元素是不可以重新放入的
         * 递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
         */
        if (nums == null || nums.length == 0) return false;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];//表示的意思是容量为j的背包，所背的物品价值可以最大为$dp[j]$
        //先遍历物品，再遍历背包容量
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {//必须要装得下当前的物品
                //物品i的重量是num[i]，其价值也是num[i]
                dp[j] = Math.max(dp[j], dp[j -nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
