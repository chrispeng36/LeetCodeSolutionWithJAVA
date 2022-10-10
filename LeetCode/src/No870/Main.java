package No870;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ChrisPeng
 * @date 2022/10/8 13:43
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Integer[] idx1 = new Integer[len];
        Integer[] idx2 = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        //对索引进行排序
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);
        int[] res = new int[len];
        int left = 0, right = len - 1;
        //每次在nums1中寻找大于nums2[i]的最小值，若没有的话则返回nums1中的最小值
        for (int i = 0; i < len; i++) {
            if (nums1[idx1[i]]>nums2[idx2[left]]){
                res[idx2[left]] = nums1[idx1[i]];
                ++left;
            }else {
                res[idx2[right]] = nums1[idx1[i]];
                -- right;
            }
        }
        return res;
    }
}