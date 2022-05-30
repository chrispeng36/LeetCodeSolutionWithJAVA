package No462;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/5/19 10:45
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minMoves2(int[] nums) {
        //给定一个长度为n的整数数组nums，返回使所有数组元素1相等需要的最少移动次数
        //找中位数
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, res = 0;
        while (i < j){
            // nums[j]要执行nums[j]-mid次减1
            // nums[i]要执行mid-nums[i]次加1
            res += nums[j --] - nums[i ++];
        }
        return res;
    }
}
