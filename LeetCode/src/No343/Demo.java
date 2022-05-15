package No343;

/**
 * @author ChrisPeng
 * @date 2022/4/29 14:31
 */
public class Demo {
    public static void main(String[] args) {

    }
}

/**
 * 动态规划五部曲：
 * 1.确定dp数组及其下标的含义，dp[i]分拆数字i，可以得到的最大乘积为dp[i]
 * 2. 确定递推关系式：
 * 有两种渠道可以获取dp[i]
 * 一个是j * (i - j)直接相乘
 * 另一个是j * dp[i - j]，相当于是拆分(i - j)
 * j是从1开始遍历，拆分j的情况在遍历j的过程中已经计算过了，那么从1遍历到j比较(i - j) * j和dp[i - j] * j 取最大的
 * j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘。
 * 3. dp的初始化：
 * dp[0] = 0;
 * dp[1] = 1;
 * 4. 确定遍历顺序：
 * dp[i]是依靠dp[i-j]的状态，所以遍历i一定是从前到后，j是从后到前
 */
class Solution {
    public int integerBreak(int n) {
        //给定一个正整数n，将其拆分为k个正整数的和，并使得这些整数的乘积最大化
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }
}
