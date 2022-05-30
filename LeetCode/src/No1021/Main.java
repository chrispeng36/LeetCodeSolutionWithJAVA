package No1021;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/5/28 13:40
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String removeOuterParentheses(String s) {
        //需要匹配的话必须长度得是偶数
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && left ++ > 0)//先执行判断是否大于0，然后再自增，不会放入首元素
                sb.append('(');
            if (s.charAt(i) == ')' && --left > 0)//先执行自减然后判断是否大于0
                sb.append(')');
        }
        return sb.toString();
    }
}