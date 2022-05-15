package No2006;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ChrisPeng
 * @date 2022/2/9 19:29
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,2,1};
        int i = solution.countKDifference(arr, 1);
        System.out.println(i);
    }
}

class Solution {
    public int countKDifference(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (Math.abs(nums[i] - nums[j]) == k){
//                    count ++;
//                }
//            }
//        }
//        return count;
        int res = 0, n = nums.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            res += cnt.getOrDefault(nums[i] - k,0) + cnt.getOrDefault(nums[i] + k,0);
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0) + 1);
        }
        return res;
    }
}
