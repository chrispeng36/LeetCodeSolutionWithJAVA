package No53;

/**
 * @author ChrisPeng
 * @date 2022/4/10 17:04
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        /**
         * 利用分治法求解最大子数组
         */
        int len = nums.length;
        if (len == 0)
            return 0;
        return maxSubArraySum(nums, 0, len - 1);
    }
    private int findMaxCrossMid(int[] arr, int low, int mid, int high){
        //一定会包含nums[mid]这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        //左边包含nums[mid]元素，计算以mid结尾的最大子数组的和
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum)
                leftSum = sum;
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        return leftSum + rightSum;
    }
    private int maxSubArraySum(int[] arr, int left, int right){
        if (left == right)
            return arr[left];
        int mid = left + (right - left) / 2;
        int leftMax = maxSubArraySum(arr, left, mid);
        int rightMax = maxSubArraySum(arr, mid + 1, right);
        int crossingMax = findMaxCrossMid(arr, left, mid, right);
        return Math.max(leftMax, Math.max(rightMax, crossingMax));
    }
}

class Solution1{
    public int maxSubArray(int[] nums) {
        //要使用复杂度n的算法
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0)
                sum += nums[i];//保证是从正数开始相加的
            else
                sum = nums[i];//如果小于0的话就重新选择一个开始的点，sum可以当作临时的和
            res = Math.max(res, sum);//一直重复更新
        }
        return res;
    }
}
