package Week315.No6204;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/10/16 10:50
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1,10,6,7,-7,1};
        int maxK = solution.findMaxK(arr);
        System.out.println(maxK);
    }
}

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] > 0 || nums[len - 1] < 0)
            return -1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = len - 1; j >= i + 1; j--) {
                if (nums[i] * nums[j] > 0)
                    break;
                if (nums[i] + nums[j] == 0)
                    return nums[j];
            }
        }
        return -1;
    }
}