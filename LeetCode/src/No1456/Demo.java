package No1456;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/2/17 12:41
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxVowels("aeiou", 2);
        System.out.println(i);
    }
}

class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while (right < s.length()){
            char temp = s.charAt(right);
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'u' || temp == 'o')
                count ++;//定位到第一个出现元音字母的位置
            right ++;
            if (right - left == k){//一直到区间的长度是k
                max = Math.max(max,count);
                char c = s.charAt(left);
                if (c == 'a' || c == 'u' || c == 'e' || c == 'i' || c == 'o')
                    count --;//如果左边的是元音字母的话就多算了一个
                left ++;
            }
        }
        return max;
    }
}
