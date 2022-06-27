package No1051;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/6/13 0:58
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,4,2,1,3};
        int i = solution.heightChecker(arr);
        System.out.println(i);
    }
}

class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (temp[i] != heights[i])
                res ++;
        }
        return res;
    }
}