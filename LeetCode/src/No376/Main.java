package No376;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/19/2022 6:51 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 7, 4, 9, 2, 5};
        int i = solution.wiggleMaxLength(arr);
        System.out.println(i);
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
//        int len = nums.length;
//        int[][] dp = new int[len][2];
//        /**
//         * dp[i][j]表示的是以i结尾的最长摆动序列长度
//         * 其中0表示上升，1表示下降
//         */
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            Arrays.fill(dp[i], 1);
//        }
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]){
//                    //大于的话就要计算是1的，前一个下降，这次上升
//                    dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
//                }else if (nums[i] < nums[j]){
//                    dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
//                }
//            }
//            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
//        }
//        return res;

        /**
         * 把dp优化一下？
         */
        int len = nums.length;
        if (len < 2)
            return len;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]){
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            }else if (nums[i] < nums[i - 1]){
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            }else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }
}