package No396;

/**
 * @author ChrisPeng
 * @date 2022/4/22 10:12
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        /**
         * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
         * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
         */
        //向右旋转一次，相当于把当前的结果加上整个数组的和，再减去数组大小乘以当前最后一位
        int tempSum = 0;
        int numsSum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            numsSum += nums[i];
            tempSum += i * nums[i];
        }
        int res = tempSum;
        for (int i = 1; i < len; i++) {
            tempSum += (numsSum - len * nums[len - i]);
            res = Math.max(res, tempSum);
        }
        return res;
    }
}
