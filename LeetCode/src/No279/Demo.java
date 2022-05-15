package No279;

/**
 * @author ChrisPeng
 * @date 2022/5/9 1:22
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numSquares(12);
        System.out.println(i);
    }
}


class Solution {
    public int numSquares(int n) {
        //给定一个整数n，返回和为n的完全平方数的最少数量
        int[] dp = new int[n + 1];
        //选最小的话初始化就应该是最大的
        int max = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        //遍历物品
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {//遍历背包
                if (dp[j - i * i] != max){//如果是最大值没有选择的必要
                    dp[j] = Math.min(dp[j],dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}