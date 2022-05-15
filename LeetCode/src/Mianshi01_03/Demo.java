package Mianshi01_03;

/**
 * @author ChrisPeng
 * @date 2022/2/15 14:29
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.replaceSpaces("Mr John Smith    ", 13);
        System.out.println(s);
    }
}

class Solution {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int i = length - 1, j = S.length() - 1;
        while (i >= 0){
            if (chars[i] == ' '){
                chars[j --] = '0';
                chars[j --] = '2';
                chars[j --] = '%';
            }else {
                chars[j --] = chars[i];
            }
            i --;
        }
        return String.valueOf(chars,j + 1,S.length() - j - 1);
    }
}