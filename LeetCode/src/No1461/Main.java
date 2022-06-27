package No1461;

import java.util.HashSet;

/**
 * @author ChrisPeng
 * @date 2022/6/2 19:28
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean hasAllCodes(String s, int k) {
        //给定一个二进制字符串s和一个整数k
        //如果所有的长度为k的二进制字符串都是s的子串，返回true，否则false
        if (s.length() < (1 << k) + k - 1)
            return false;//长度至少为2 ^ k + k - 1

        HashSet<String> exists = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            exists.add(s.substring(i, i + k));
        }
        return exists.size() == (1 << k);
    }
}