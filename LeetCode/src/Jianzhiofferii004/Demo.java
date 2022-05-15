package Jianzhiofferii004;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/1/23 18:00
 */
public class Demo {
    public static void main(String[] args) {

    }
}
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 2] != nums[nums.length - 1])
            return nums[nums.length - 1];
        if (nums[0] != nums[1])
            return nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1])
                return nums[i];
        }
        return 0;
    }
}