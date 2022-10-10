package No91;

/**
 * @author ChrisPeng
 * @date 9/21/2022 9:58 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numDecodings("230");
        System.out.println(i);
    }
}

class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        if (len < 2)
            return 1;
        /**
         * 如果符合要求的话：dp[i] = dp[i-1]+dp[i-2]
         * 如果不符合要求的话：
         * 1. 当前数字是0，那么这个必须得带着前面那个走，dp[i] = dp[i - 2]
         * 2. 当前数字和前一个数字加起来大于26
         */
        dp[0] = 1;//当只有一位的时候只有唯一的解码方式

        for (int i = 0; i < len; i++) {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];//dp[i+1]=dp[i]+dp[i-1]的条件是当前位不为0，并且与之前位的组成的数字小于26
            }
        }
        return dp[len];
    }
}