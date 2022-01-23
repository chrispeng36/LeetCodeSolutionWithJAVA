package No747;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/1/13 9:10
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {3,6,1,0};
        Solution solution = new Solution();
        int i = solution.dominantIndex(arr);
        System.out.println(i);
    }
}

class Solution {
    public int dominantIndex(int[] nums) {
        int[] arr = nums.clone();
        int k = 0;
        if (nums.length == 1)
            return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == nums[nums.length - 1]){
                k = i;
                break;
            }
        }
        return nums[nums.length - 1] >= nums[nums.length - 2] * 2 ? k : -1;
    }
}
