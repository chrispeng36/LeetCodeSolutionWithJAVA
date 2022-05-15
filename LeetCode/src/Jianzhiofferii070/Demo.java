package Jianzhiofferii070;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/2/10 12:52
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,2,3,3,4,4,8,8};
        int i = solution.singleNonDuplicate(arr);
        System.out.println(i);
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                return nums[i];
        }
        return 0;
    }
}