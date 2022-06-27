package No1493;

/**
 * @author ChrisPeng
 * @date 2022/6/4 11:11
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,0,1};
        int i = solution.longestSubarray(nums);
        System.out.println(i);
    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        //给定一个二进制数组nums，需要从中删除一个元素
        //请在删除掉元素的结果数组中，返回最长的且只包含1的非空子数组的长度
        /**
         * 如果知道i - 1结尾和i + 1开头的最长连续为1的子数组
         * 那么相加就是删除第i位的最长连续为1的子数组
         * 以第i位结尾的最长连续全1的子数组
         * left[i] = 0 (ai = 0) 或者 = left[i - 1] + 1;(ai = 1)
         * 以第i位开头的最长连续全1子数组
         * right[i] = 0 (ai = 0) 或者 = left[i + 1] + 1; (ai = 1)
         */
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];//初始化
        for (int i = 1; i < len; i++) {
            left[i] = nums[i] == 1 ? left[i - 1] + 1 : 0;
        }
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i] == 1 ? right[i + 1] + 1 : 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            int leftSum = i == 0 ? 0 : left[i - 1];
            int rightSum = i == len - 1 ? 0 : right[i + 1];
            res = Math.max(res, leftSum + rightSum);
        }
        return res;
    }
}