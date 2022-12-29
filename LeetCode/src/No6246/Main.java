package No6246;

/**
 * @author ChrisPeng
 * @date 2022/11/27 11:28
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.appendCharacters("coaching", "coding");
        System.out.println(i);
    }
}

class Solution {
    public int appendCharacters(String s, String t) {
        int left_s = 0, left_t = 0;
        int res = 0;
        while (left_t < t.length()) {
            char ch = t.charAt(left_t);//t当前需要匹配的字符
            boolean flag = false;//标志位
            while (left_s < s.length()) {
                if (ch == s.charAt(left_s)){
                    res ++;
                    left_s ++;
                    flag = true;
                    break;
                }
                left_s ++;
            }
            if (flag) left_t ++;
            else break;
        }
        return t.length() - res;
    }
}
