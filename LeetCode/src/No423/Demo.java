package No423;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/11/24 0:05
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public String originalDigits(String s) {
        int[] is = new int[26];
        //首先统计各个字符的个数
        for (int c : s.toCharArray()) {
            is[c - 'a']++;
        }
        int[] res = new int[10];
        res[0] = is['z' - 'a'];
        res[2] = is['w' - 'a'];
        res[4] = is['u' - 'a'];
        res[6] = is['x' - 'a'];
        res[8] = is['g' - 'a'];
        res[3] = is['h' - 'a'] - res[8];
        res[5] = is['f' - 'a'] - res[4];
        res[7] = is['s' - 'a'] - res[6];
        res[9] = is['i' - 'a'] - res[5] - res[6] - res[8];
        res[1] = is['n' - 'a'] - res[7] - res[9] - res[9];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}