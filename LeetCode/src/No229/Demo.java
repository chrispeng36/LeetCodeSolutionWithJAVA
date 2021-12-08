package No229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/10/22 0:05
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,3,2,2,2};
        List<Integer> list = solution.majorityElement(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<>();
//        //首先使用哈希表的方式
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (! map.containsKey(nums[i]))
//                map.put(nums[i],1);
//            else
//                map.put(nums[i],map.get(nums[i]) + 1);
//        }
//        for (Integer integer : map.keySet()) {
//            if (map.get(integer) > nums.length / 3)
//                list.add(integer);
//        }
//        return list;
        /**
         * 另外一种方式
         * 考虑嗯求
         */
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length == 1){
            list.add(nums[0]);
            return list;
        }

        if(nums.length == 2){
            list.add(nums[0]);
            if(nums[1] != nums[0])
                list.add(nums[1]);
            return list;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; (i + len / 3) < len; i++) {
            if ((nums[i] == nums[i + len / 3]) && (!list.contains(nums[i])))
                list.add(nums[i]);
            if (list.size() == 2)
                break;
        }
        return list;
    }
}