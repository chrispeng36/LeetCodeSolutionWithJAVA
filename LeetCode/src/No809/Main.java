package No809;

/**
 * @author ChrisPeng
 * @date 2022/11/26 9:43
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int expressiveWords(String s, String[] words) {
        /**
         * 首先要判断每个字符串t是否能够扩张成给定的字符串s
         * 首先需要保证s[i] = t[j]，否则这两部分不是相同的字母，无法进行扩张
         * 随后不断向右移动两个指针，直到移动到与之前不同的字母，或者超出字符的边界
         * 假设字符串s有cnt_i个相同的字母，t有cnt_j个相同的字母，必须有cnt_i >= cnt_j，因为扩张不可能减少字符的数量
         * 当cnt_i > cnt_j的时候，由于扩张至少会达到长度3以上，因此需要保证cnt_i >= 3即可
         */
        int ans = 0;
        for (String word : words) {
            if (expand(s, word))
                ++ ans;
        }
        return ans;
    }

    private boolean expand(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {//开头就不一样的话就必然不一样
                return false;
            }

            char ch = s.charAt(i);
            int cnti = 0;//记录i这个字符重复了多少次
            while (i < s.length() && s.charAt(i) == ch) {
                ++ cnti;
                ++ i;
            }
            int cntj = 0;//记录j处的字符重复了多少次
            while (j < t.length() && t.charAt(j) == ch) {
                ++ cntj;
                ++ j;
            }
            if (cnti < cntj) return false;
            if (cnti != cntj && cnti < 3) return false;
        }
        return i == s.length() && j == t.length();
    }
}