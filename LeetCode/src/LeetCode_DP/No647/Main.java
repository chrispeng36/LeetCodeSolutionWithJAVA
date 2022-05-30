package LeetCode_DP.No647;

/**
 * @author ChrisPeng
 * @date 2022/5/30 9:44
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countSubstrings(String s) {
        //给定一个字符串s，统计并返回这个字符串的回文子串的数目
        /**
         * dp[i][j]表示区间范围[i,j]中的子串是否为回文子串
         * s[i]与s[j]不相等时，dp[i][j]一定是false
         * s[i]与s[j]相等时，有三种情况：
         * 1. 下标i与j相同，那么是回文子串
         * 2. 下标i与j相差为1，那么也是回文
         * 3. 下标i与j相差大于1，此时s[i]与s[j]已经相同了，那么就看dp[i + 1][j - 1]是否为空
         */
//        int len, ans = 0;
//        if (s == null || (len = s.length()) < 1) return 0;
//        //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
//        boolean[][] dp = new boolean[len][len];
//        for (int j = 0; j < len; j++) {
//            for (int i = 0; i <= j; i++) {
//                //当两端字母一样时，才可以两端收缩进一步判断
//                if (s.charAt(i) == s.charAt(j)) {
//                    //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        //否则通过收缩之后的字串判断
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                } else {//两端字符不一样，不是回文串
//                    dp[i][j] = false;
//                }
//            }
//        }
//        //遍历每一个字串，统计回文串个数
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                if (dp[i][j]) ans++;
//            }
//        }
//        return ans;
        /**中心扩散法**/
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两遍扩散，并判断是否为回文子串
            //有两种情况，left == right 以及 right = left + 1
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                //如果当前是一个·回文串，则记录数量
                ans ++;
                left --;
                right ++;
            }
        }
        return ans;
    }
}