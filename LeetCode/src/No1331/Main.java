package No1331;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ChrisPeng
 * @date 2022/7/28 8:32
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {40, 10, 20, 30};
        int[] res = solution.arrayRankTransform(arr);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[][] nums = new int[len][2];
        for (int i = 0; i < len; i++) {
            nums[i] = new int[]{arr[i],i};//值对应下标
        }
        //按照值的大小进行排序
        Arrays.sort(nums, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[len];
        for (int i = 0, j = 1; i < len; i++) {
            ans[nums[i][1]] = j;
            if (i != len - 1 && nums[i][0] != nums[i + 1][0]){
                j ++;
            }
        }
        return ans;
    }
}