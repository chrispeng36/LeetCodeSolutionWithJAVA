package No978;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/19/2022 1:50 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 5};
        int i = solution.maxTurbulenceSize(arr);
        System.out.println(i);
    }
}

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        /**
         * dp[i][j]表示的是到i处包含i，结尾状态是j的最长子数组的长度
         * 这里必须包含i结尾，0上升1下降
         */
        int res = 1;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]){
                dp[i][0] = dp[i - 1][1] + 1;
            }else if (arr[i] < arr[i - 1]){
                dp[i][1] = dp[i - 1][0] + 1;
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
