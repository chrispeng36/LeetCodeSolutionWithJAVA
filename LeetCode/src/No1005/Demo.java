package No1005;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/12/3 10:25
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,-1,0,2};
        int i = solution.largestSumAfterKNegations(arr, 3);
        System.out.println(i);
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //策略就是每一次修改之后都能让当前的是最大的和
        /**
         * 每次修改可能存在的情况是：
         * 1.全部为正数：修改最小的
         * 2.存在负数：修改最大的
         */
        for (int i = 0; i < k; i++) {
            int minTemp = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[minTemp] > nums[j])
                    minTemp = j;
            }
            nums[minTemp] = -nums[minTemp];
        }
        int count  = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        return count;
    }
}