package No28;

/**
 * @author ChrisPeng
 * @date 2022/6/9 12:26
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strStr("hello", "ll");
        System.out.println(i);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        //给定两个字符串，在haystack中找出needle字符串第一个出现的位置
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j ++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private void getNext(int[] next, String s){
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j ++;
            next[i] = j;
        }
    }
}