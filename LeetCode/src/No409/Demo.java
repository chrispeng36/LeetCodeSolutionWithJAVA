package No409;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/4/18 9:08
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestPalindrome("abccccdd");
        System.out.println(i);
    }
}

class Solution {
    public int longestPalindrome(String s) {
        int len = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i),1);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) % 2 == 0)
                res += map.get(character);//是偶数的话就直接添加
            else
                res += map.get(character) - 1;
        }
        return res == s.length() ? res : res + 1;
    }
}
