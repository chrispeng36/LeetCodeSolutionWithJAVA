package LeetCode_DP.No122;

/**
 * @author ChrisPeng
 * @date 2022/5/13 11:16
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        Solution solution = new Solution();
        int i = solution.maxProfit(arr);
        System.out.println(i);
    }
}

class Solution {
    public int maxProfit(int[] prices){
        /**
         * 给定一个整数数组prices
         * 第i个元素表示某只股票第i天的价格
         * 每天可以决定是否购买和/或出售股票
         * 任何时候最多只能持有一只股票，可以在同一天出售
         */
        //贪心算法
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        }
        return res;
    }
}


