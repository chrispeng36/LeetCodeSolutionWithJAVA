package No1358;

/**
 * @author ChrisPeng
 * @date 2022/4/24 21:37
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numberOfSubstrings(String s) {
        /**
         * 给定一个字符串s，它只包含三种字符a，b，c
         * 返回a，b，c都至少出现过一次的子字符串数目
         */
        int res = 0;
        int[] counts = new int[3];
        char[] chars = s.toCharArray();

        for (int left = 0, right = 0; right < chars.length; right ++){
            counts[chars[right] - 'a']++;//因为只有abc三个字母,记录abc的个数
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0){//三个字母都有
                counts[chars[left ++] - 'a'] --;//从后一个开始
                res += chars.length - right;//记录当前的子串的个数
            }
        }
        return res;
    }
}
