package No453;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/10/20 9:09
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        int i = solution.minMoves(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        //找到最小值
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }
}