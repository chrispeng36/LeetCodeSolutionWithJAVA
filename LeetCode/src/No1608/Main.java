package No1608;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/12/2022 10:38 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] >= len)
            return len;
        for (int i = 1; i < len; i++) {
            if (nums[len - i] >= i && nums[len - 1 - i] < i)
                return i;
        }
        return -1;
    }
}
