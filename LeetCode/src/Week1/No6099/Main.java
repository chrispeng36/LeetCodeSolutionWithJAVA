package Week1.No6099;

import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/6/19 10:50
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestSubsequence("1001010", 5);
        System.out.println(i);
    }
}


class Solution {
    public int longestSubsequence(String s, int k) {
        //s的最长子列，且该子列对应二进制数字小于等于k
        int len = s.length();
        int tempNum = 0;
        int count = 0;
        int res = 0;
        boolean flag = false;
        for (int i = len - 1; i >= 0; i--) {//从右往左找定位到第一个大于k的地方
            tempNum += Math.pow(2, count) * (s.charAt(i) - '0');
            count ++;//添加了一个元素，下一次就是+1的pow
            res ++;//个数添加了1
            if (tempNum > k){
                flag = true;
                break;
            }
        }
        if (flag == false)
            return res;
        res -= 1;
        for (int i = 0; i < len - count; i++) {
            //再在左边找0
            if (s.charAt(i) == '0')
                res ++;
        }
        return res;
    }
}