package Week315.No6207;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/10/16 11:23
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 1};
        long l = solution.countSubarrays(arr, 1, 1);
        System.out.println(l);
    }
}


class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        ArrayList<Integer> minIdxList = new ArrayList<>();
        ArrayList<Integer> maxIdxList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) minIdxList.add(i);
            if (nums[i] == maxK) maxIdxList.add(i);
        }
        if (minK == maxK){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == minK){
                    res ++;//算1个的
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] == minK)
                            res ++;
                    }
                }
            }
            return res;
        }
        for (int i = 0; i < minIdxList.size(); i++) {
            for (int j = 0; j < maxIdxList.size(); j++) {
                int startIdx = Math.min(minIdxList.get(i), maxIdxList.get(j));
                int endIdx = Math.max(minIdxList.get(i), maxIdxList.get(j));
                for (int k = startIdx; k <= endIdx; k++) {
                    if (nums[k] > maxK || nums[k] < minK)
                        break;
                }
                res ++;
            }
        }
        return res;
    }
}