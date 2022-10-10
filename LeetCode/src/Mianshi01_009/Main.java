package Mianshi01_009;

/**
 * @author ChrisPeng
 * @date 9/29/2022 10:08 AM
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
        Solution solution = new Solution();
        boolean b = solution.isFlipedString(s1, s2);
        System.out.println(b);
    }
}

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
        /**s1 = "waterbottle", s2 = "erbottlewat"**/
        for (int i = 0; i < len1; i++) {
            if ((s1.substring(i, len1) + s1.substring(0, i)).equals(s2))
                return true;
        }
        return false;
    }
}