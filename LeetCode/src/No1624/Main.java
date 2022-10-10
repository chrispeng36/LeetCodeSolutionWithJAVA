package No1624;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 9/17/2022 11:19 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxLengthBetweenEqualCharacters("aydsicwrfybunpqsdsnenvrfirr");
        System.out.println(i);
    }
}

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        //将字符第一个出现的位置记录到哈希表
        for (int i = 0; i < chars.length; i++) {
            if (! map.containsKey(chars[i]))
                map.put(chars[i], i);
        }
        //倒序遍历字符数组，计算出间距
        int maxCount = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (map.containsKey(chars[i])){
                if (map.containsKey(chars[i])){
                    int max = i - map.get(chars[i]) - 1;
                    if (max > maxCount)
                        maxCount = max;
                }
            }
        }
        return maxCount;
    }
}