package No2032;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/10/17 11:16
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,1,3,2};
        int[] nums2 = {2,3};
        int[] nums3 = {3};
        List<Integer> list = solution.twoOutOfThree(nums1, nums2, nums3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        /**
         * 返回一个至少在两个数组中出现过的元素
         */
       //创建一个哈希表存储出现过的元素
       int[] s = new int[101];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums3) {
            set3.add(i);
        }

        for (Integer i : set1) s[i] ++;
        for (Integer i : set2) s[i] ++;
        for (Integer i : set3) s[i] ++;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            if (s[i] >= 2)
                list.add(i);
        }
        return list;
    }
}