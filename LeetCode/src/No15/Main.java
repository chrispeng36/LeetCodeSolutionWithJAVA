package No15;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 8/26/2022 5:10 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 0, -2, -1, 1, 2};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    private Set<List<Integer>> res;
//    private HashMap<Integer, Integer> corr;
    public List<List<Integer>> threeSum(int[] nums) {
//        corr = new HashMap<>();
        res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 1 && nums[i] == nums[i - 1])
                continue;
            twoSum(0 - nums[i], nums, i);
        }
        return new  ArrayList<>(res);
    }

    private void twoSum(int target, int[] nums, int idx){
        if (nums == null || nums.length <= 1)
            return;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = idx + 1; i < nums.length; i++) {
            int v = target - nums[i];
            Integer exist = map.get(v);
            if (exist != null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0 - target);list.add(nums[exist]);list.add(nums[i]);
                res.add(list);
            }
            map.put(nums[i], i);
        }
    }
}