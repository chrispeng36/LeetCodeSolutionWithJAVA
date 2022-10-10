package No921;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 10/4/2022 9:35 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0, record = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                record ++;
            else {
                if (record != 0) record --;
                else res ++;
            }
        }
        return res + record;
    }
}