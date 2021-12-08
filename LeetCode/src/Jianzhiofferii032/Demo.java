package Jianzhiofferii032;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2021/10/26 16:08
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean anagram = solution.isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        //如果两个单词中出现的字符的个数相同但是字符顺序不完全相同
        if(s.equals(t))
            return false;
        if (s.length() != t.length())
            return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[i])
                return false;
        }
        return true;
    }
}
