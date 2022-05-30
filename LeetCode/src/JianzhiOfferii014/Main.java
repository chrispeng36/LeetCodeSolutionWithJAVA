package JianzhiOfferii014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/5/16 9:32
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkInclusion("ab", "eidbaooo");
        System.out.println(b);
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a'] ++;
            b[s2.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(a, b))
            return true;//判断字符串数组是否相等，因为长度都是一样的，所以总能排列一致
        int left = 0, right = s1.length();//左0右指针s1的长度
        /**以下滑动窗口是为了保证窗口的大小和字符串s1的大小相等**/
        while (right < s2.length()){
            b[s2.charAt(right) - 'a'] ++;
            b[s2.charAt(left) - 'a'] --;
            if (Arrays.equals(a, b))
                return true;
            right ++;
            left ++;
        }
        return false;
    }
}
