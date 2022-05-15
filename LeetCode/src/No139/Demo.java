package No139;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/9 14:09
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
         * 请你判断是否可以利用字典中出现的单词拼接出 s 。
         * 单词可以重复使用
         * 那么就是一个完全背包的问题
         */

        /**
         * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
         *
         * 如果求排列数就是外层for遍历背包，内层for循环遍历物品
         */
        boolean[] dp = new boolean[s.length() + 1];//表示前i的子串是否能被字典构成
        dp[0] = true;//空字符串初始化能构造成
        for (int i = 1; i <= s.length(); i++) {//先遍历背包
            for (int j = 0; j < i; j++) {//遍历物品
                if (wordDict.contains(s.substring(j ,i)) && dp[j])
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}
