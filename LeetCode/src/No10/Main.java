package No10;

/**
 * @author ChrisPeng
 * @date 2022/6/14 21:07
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        //给定一个字符串s和一个字符规律p
        //实现一个支持'.'和'*'的正则表达式匹配
        //'.'匹配任意单个字符，'*'匹配零个或者多个前面那个元素
        if (p.isEmpty()) return s.isEmpty();

        boolean first_match = ! s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1),p));
        else
            return first_match && isMatch(s.substring(1),p.substring(1));
    }
}