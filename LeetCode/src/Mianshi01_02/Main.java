package Mianshi01_02;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 9/27/2022 9:58 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }
        return true;
    }
}