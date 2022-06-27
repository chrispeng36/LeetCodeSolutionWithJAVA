package No1984;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/6/13 9:56
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {64407, 3036};
        int i = solution.minimumDifference(arr, 2);
        System.out.println(i);
    }
}

class Solution {
    public int minimumDifference(int[] nums, int k) {
        //挑出任意k个数，使得最高分和最低分的差值尽可能小
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length + 1 - k; i++) {
            if (nums[i + k - 1] - nums[i] < min)
                min = nums[i + k - 1] - nums[i];
        }
        return min;
    }
}
