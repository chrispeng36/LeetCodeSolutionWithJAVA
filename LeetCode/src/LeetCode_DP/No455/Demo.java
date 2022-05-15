package LeetCode_DP.No455;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/4/21 21:31
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {10,9,7,8};
        int[] s = {5,6,7,8};
        int i = solution.findContentChildren(g, s);
        System.out.println(i);
    }
}

class Solution {
    /**
     *
     * @param g 对于每个小孩子的胃口值
     * @param s 每块饼干的尺寸，如果s[j] > g[i]表示这个小孩子分到这个饼干能够满足
     * @return 最多能够满足小孩子的数量
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int len_cookie = s.length;
        int len_kid = g.length;
        int res = 0;
        for (int i = 0, j = 0; i < len_cookie && j < len_kid; i++, j++) {
            while (i < len_cookie && g[j] > s[i])
                i ++;
            if (i < len_cookie)
                res ++;
        }
        return res;
    }
}
