package No926;

/**
 * @author ChrisPeng
 * @date 2022/6/11 8:14
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minFlipsMonoIncr("00110");
        System.out.println(i);
    }
}

class Solution {
    public int minFlipsMonoIncr(String s) {
        int m = s.length();
        int[][] dp = new int[m + 1][2];//表示第i位为0或者为1的时候需要修改的最小位数
        /**
         * 这里的状态转移方程为：
         * dp[i][0]=dp[i−1][0]+I(s[i]=‘1’)
         * dp[i][1]=min(dp[i−1][0],dp[i−1][1])+I(s[i]=‘0’)
         */
        for (int i = 1; i <= m; i++) {
            if (s.charAt(i - 1) == '0'){
                dp[i][0] = dp[i - 1][0];//如果前一位也是0的话，只有当前一位是0的时候才满足递增
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;//前一位是0，但是该位为1，前一位是0或者1都行
            }else {
                dp[i][0] = dp[i - 1][0] + 1;//前一位是1，当前是0，那么必须得修改一位
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[m][0], dp[m][1]);
    }
}