package JianzhiOffer49;

/**
 * @author ChrisPeng
 * @date 2022/2/16 19:24
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean b = solution.isUglyNumber(210);
//        System.out.println(b);
        int i = solution.nthUglyNumber(10);
        System.out.println(i);
    }
}

class Solution {
    public int nthUglyNumber(int n) {
//        int len = Integer.MAX_VALUE;
//        int count = 1,Num = 2;
//        while (Num < len){
//            if (isUglyNumber(Num))
//                count ++;
//            if (count == n)
//                break;
//            Num ++;
//        }
//        return Num;
        if (n <= 0)
            return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int id2 = 0,id3 = 0,id5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] *3, dp[id5] * 5));
            // 这里不用else if的原因是有可能id2(3) * 2 == id3(2) * 3
            // 这种情况两个指针都要后移
            if (dp[id2] * 2 == dp[i])
                id2 += 1;
            if (dp[id3] * 3 == dp[i])
                id3 += 1;
            if (dp[id5] * 5 == dp[i])
                id5 += 1;
        }
        return dp[n - 1];
    }
//    public boolean isUglyNumber(int n){
//        while (n % 5 == 0 || n % 3 == 0 || n % 2 == 0){
//            if (n % 5 == 0)
//                n /= 5;
//            if (n % 3 == 0)
//                n /= 3;
//            if (n % 2 == 0)
//                n /= 2;
//        }
//        return n == 1;
//    }
}