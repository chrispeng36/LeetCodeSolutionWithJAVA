package LCP28;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/12/23 9:41
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1};
        int i = solution.purchasePlans(nums, 6);
        System.out.println(i);
    }
}

class Solution {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        //排序完之后
        if (nums[0] + nums[1] > target)
            return 0;
        long count = 0;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        while (leftPointer < rightPointer){
            while (nums[leftPointer] + nums[rightPointer] > target && rightPointer > 0)
                rightPointer --;
            count = (count + Math.max(rightPointer - leftPointer,0)) % 1000000007;
            leftPointer ++;
        }
        return (int) count;
    }
}
