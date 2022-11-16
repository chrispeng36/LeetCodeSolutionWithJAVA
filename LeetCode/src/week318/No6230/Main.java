package week318.No6230;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/11/6 10:38
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 7, 8, 9};
        long l = solution.maximumSubarraySum(arr, 3);
        System.out.println(l);
    }
}

//class Solution {
//    public long maximumSubarraySum(int[] nums, int k) {
//        int len = nums.length;
//        if (len < k) return 0;
//        long max = 0;
//        for (int i = 0; i <= len - k; i++) {
//            long tempSum = 0;
//            ArrayList<Integer> list = new ArrayList<>();
//            boolean flag = true;
//            //计算sum
//            for (int j = i; j < i + k; j++) {
//                tempSum += nums[j];
//                if (list.contains(nums[j])){
//                    flag = false;
//                    break;
//                }
//                list.add(nums[j]);
//            }
//            if (tempSum > max && flag){
//                max = tempSum;
//            }
//        }
//        return max;
//    }
//}

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        //维护元素出现的次数
        HashMap<Integer, Integer> count = new HashMap<>();
        //维护元素的和
        long res = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        //如果前k个元素是不重复的，那么就作为起始的窗口
        if (count.size() == k) res = Math.max(res, sum);
        for (int i = k; i < len; i++) {
            //右指针右移
            sum += nums[i];//加入一个元素的和
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);//把这个元素的个数加入
            //左指针右移
            sum -= nums[i - k];//保证元素的个数是k
            int cnt = count.get(nums[i - k]);
            if (cnt == 1){
                count.remove(nums[i - k]);
            }else {
                count.put(nums[i - k], cnt - 1);
            }
            if (count.size() == k){
                res = Math.max(res, sum);
            }

        }
        return res;
    }
}