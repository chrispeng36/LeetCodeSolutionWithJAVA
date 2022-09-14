package No873;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/7/9 22:32
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int res = 0;
        int sum;
        int[][] dp = new int[n][n];
        //dp[i][j]表示以A[i], A[j]结尾的子序列的最大斐波那契数列长度
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            left = 0;
            right = i - 1;
            while (left < right){
                sum = arr[left] + arr[right];
                if (sum == arr[i]){
                    dp[right][i] = Math.max(dp[right][i], dp[left][right] + 1);
                    res = Math.max(dp[right][i], res);
                    left ++;
                    right --;
                }else if (sum < arr[i]){
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return res;
    }
}