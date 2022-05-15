package LeetCode_DP.No70;

/**
 * @author ChrisPeng
 * @date 2022/4/25 13:42
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.climbStairs(4);
        System.out.println(i);
    }
}

class Solution {
    public int climbStairs(int n) {
        //递归的方式，超出时间限制了
//        if(n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        return climbStairs(n - 1) + climbStairs(n - 2);
        //迭代方式
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }
}
