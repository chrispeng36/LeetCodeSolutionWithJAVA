package No795;

/**
 * @author ChrisPeng
 * @date 2022/11/24 10:22
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        /**
         * 给定一个整数数组和两个整数：left和right
         * 找出nums中连续非空且其中最大元素在范围[left, right]中的子数组
         * 返回子数组的个数
         */
        if (left > right) return 0;
        //最大元素满足大于等于left小于等于right的子数组个数 = 最大元素小于right的子数组个数 - 最大元素大于等于left的个数
        return numSubarryBoundedMax(nums, right) - numSubarryBoundedMax(nums, left);
    }

    private int numSubarryBoundedMax(int[] arr, int max) {
        int res = 0;
        int numSubarray = 0;
        for (int num : arr) {
            if (num <= max){
                numSubarray ++;
                res += numSubarray;//每次多出现一个数字，就会在之前的基础上加上1
            } else {
                numSubarray = 0;
            }
        }
        return res;
    }
}
