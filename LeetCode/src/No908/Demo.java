package No908;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/4/30 10:59
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - 1] - 2 * k > nums[0] ? nums[nums.length - 1] - 2 * k - nums[0] : 0;
    }
}