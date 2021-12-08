package No260;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/10/30 9:37
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,1,3,2,5};
        int[] ints = solution.singleNumber(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<>();
//        Arrays.sort(nums);
//        if (nums[0] != nums[1]){
//            list.add(nums[0]);
//        }
//        if (nums[nums.length - 1] != nums[nums.length - 2])
//            list.add(nums[nums.length - 1]);
//        if (list.size() == 2)
//            return list.stream().mapToInt(Integer::intValue).toArray();
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] != nums[i + 1] && nums[i - 1] != nums[i])
//                list.add(nums[i]);
//            if (list.size() == 2)
//                break;
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();

        //使用位运算的方法来解决
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        //防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0)
                type1 ^= num;
            else
                type2 ^= num;
        }
        return new int[]{type1,type2};
    }
}