package No1781;

/**
 * @author ChrisPeng
 * @date 2022/12/12 12:47
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int beautySum(String s) {
        //出现频率最高与最低的次数之差
        //返回所有的美丽值之和
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a'] ++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0)
                        minFreq = Math.min(minFreq, cnt[k]);
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}