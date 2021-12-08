package No372;

import static java.lang.Math.pow;

/**
 * @author ChrisPeng
 * @date 2021/12/5 20:48
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,0,0};
        int i = solution.superPow(2147483647, arr);
        System.out.println(i);
    }
}

class Solution {
    static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        /**
         * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，
         * b 是一个非常大的正整数且会以数组形式给出。
         */
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }
    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}