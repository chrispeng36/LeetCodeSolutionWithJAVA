package No442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/11/16 11:16
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> list = solution.findDuplicates(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length < 2)
            return list;
        if (nums.length == 2){
//            System.out.println("=========================");
            if (nums[0] == nums[1]){
                list.add(nums[0]);
                return list;
            } else
                return list;
        }

        Arrays.sort(nums);
        if (nums[0] == nums[1] && nums[1] != nums[2])
            list.add(nums[0]);
        if (nums[nums.length - 1] == nums[nums.length -2] && nums[nums.length - 2] != nums[nums.length - 3])
            list.add(nums[nums.length - 1]);
        int i = 1;
        while (i < nums.length - 2){
            if (nums[i] == nums[i + 1] && nums[i + 1] != nums[i + 2]){
                list.add(nums[i]);
                i += 2;
            }else {
                i ++;
            }
        }
        return list;
    }
}
