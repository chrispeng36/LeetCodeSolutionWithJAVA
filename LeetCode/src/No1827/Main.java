package No1827;

/**
 * @author ChrisPeng
 * @date 2022/12/11 14:23
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += Math.max(0, nums[i - 1] + 1 - nums[i]);
            nums[i] = Math.max(nums[i], nums[i - 1] + 1);
        }
        return res;
    }
}
