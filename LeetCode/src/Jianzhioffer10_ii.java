/**
 * @author ChrisPeng
 * @date 2022/3/30 20:44
 */
public class Jianzhioffer10_ii {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int i = solution1.numWays(7);
        System.out.println(i);
    }
}

class Solution1 {
    public int numWays(int n) {
//        //这个题目可以倒推，到达第n个阶梯可以从n-1跳一跳
//        //n-2跳两跳
//        if (n == 0)
//            return 1;
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];

    }
}