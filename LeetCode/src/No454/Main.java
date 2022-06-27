package No454;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/6/8 11:05
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {1,2};
        int[] arr2 = {-2,-1};
        int[] arr3 = {-1, 2};
        int[] arr4 = {0, 2};
        int i = solution.fourSumCount(arr1, arr2, arr3, arr4);
        System.out.println(i);
    }
}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //给定四个整数数组，数组长度都是n
        //计算有多少个四元组满足nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0;
        //key：a + b的数值，value：a + b出现的次数
        HashMap<Integer, Integer> umap = new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                umap.put(i + i1, umap.getOrDefault(i + i1, 0) + 1);
            }
        }
        int count = 0;//统计和为零出现的次数
        for (int i : nums3) {
            for (int i1 : nums4) {
                if (umap.containsKey(0 - i - i1)){
                    count += umap.get(0 - i - i1);
                }
            }
        }
        return count;
    }
}
