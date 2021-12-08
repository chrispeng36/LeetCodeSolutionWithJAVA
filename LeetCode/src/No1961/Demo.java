package No1961;

/**
 * @author ChrisPeng
 * @date 2021/10/13 8:16
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"i","love","leetcode"};
        boolean b = solution.isPrefixString("iloveleetcode", arr);
        System.out.println(b);
    }
}

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String s1 = "";
        for (int i = 0; i < words.length; i++) {
            s1 += words[i];
            if (s1.equals(s))
                return true;
        }
        return false;
    }
}