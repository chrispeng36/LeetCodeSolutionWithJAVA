package No264;

/**
 * @author ChrisPeng
 * @date 9/8/2022 8:47 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int nthUglyNumber(int n) {
        /**
         * dp[i]表示的是第i个丑数
         * dp[1]=1
         * 定义三个指针p2,p3,p5
         * 表示下一个丑数是当前指针指向的丑数乘以对应的质因数
         * 初始时三个指针的值都是1
         * 2<=i<=n时，dp[i]=min(dp[p2] x 2, dp[p3] x 3, dp[p5] x 5)
         * 然后比较dp[i], dp[p2] x 2, dp[p3] x 3, dp[p5] x 5是否相等，相等的话则将对应的指针加1
         *
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2)
                p2 ++;
            if (dp[i] == num3)
                p3 ++;
            if (dp[i] == num5)
                p5 ++;
        }
        return dp[n];
    }
}