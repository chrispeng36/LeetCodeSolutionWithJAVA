package No1636;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 9/19/2022 9:39 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 1, 2, 2, 2};
        int[] ints = solution.frequencySort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()){
                    //频率相同的话就按值降序排序
                    return o2.getKey() - o1.getKey();
                }else {
                    //频率不同按频率升序
                    return o1.getValue() - o2.getValue();
                }
            }
        });
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[idx] = entry.getKey();
                idx ++;
            }
        }
        return nums;
    }
}