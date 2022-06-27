package No2063;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/5/31 16:20
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long aba = solution.countVowels("aba");
        System.out.println(aba);
    }
}

class Solution {
    public long countVowels(String word) {
        //给定一个字符串，返回word的所有的子字符串中元音的总数
        //dp[i]表示加入当前字符word[i-1]后相比上一个状态能增加的元音字母的个数
        long[] dp = new long[word.length() + 1];
        for (int i = 1; i <= word.length(); i++) {
            char ch = word.charAt(i - 1);
            //如果当前字符不是元音，比如ab, dp[1]=1，而加入b之后，只能增加一种情况，也就是ab,dp[2]=1
            //如果当前字符是元音，比如aba，相比ab状态多了a,ba,aba三种情况，因此dp[3]=dp[2]+3
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                dp[i] = dp[i - 1] + i;
            else
                dp[i] = dp[i - 1];
        }
        return Arrays.stream(dp).sum();
    }
}
