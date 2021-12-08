package No1957;

/**
 * @author ChrisPeng
 * @date 2021/12/7 9:00
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public String makeFancyString(String s) {
        /**
         * 给定一个字符串，从s中删除最少的字符，使其变为一个没有三个连续相同的字符
         */
        StringBuilder stringBuilder = new StringBuilder();
        s = " " + s;
        char[] chars = s.toCharArray();
        int flag = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[1] == chars[i - 1]) flag ++;
            else flag = 1;
            if (flag < 3) stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}