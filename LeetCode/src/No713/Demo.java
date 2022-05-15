package No713;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/5 9:28
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {10, 5, 2, 6};
        int i = solution.numSubarrayProductLessThanK(arr, 100);
        System.out.println(i);
    }
}

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int product = 1, len = nums.length, start = 0, count = 0;
//        for (int i = 0; i < len; i++) {
//            product = product * nums[i];
//            if (product < k){
//                count ++;
//                if (i == len - 1 && start != i){
//                    product = 1;
//                    start ++;
//                    i = start - 1;
//                }
//            }else {
//                product = 1;
//                start ++;
//                i = start - 1;
//            }
//        }
//        return count;
        //滑动窗口的解法
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k){
                prod /= nums[i];
                i ++;
            }
            ret += j - i + 1;//计算出有多少个，是按照元素的个数来的
        }
        return ret;
    }
}
