package Jianzhiofferii018;

/**
 * @author ChrisPeng
 * @date 2021/10/19 19:05
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean huiwen = solution.isPalindrome("1A man, a plan, a canal: Panama1");
        System.out.println(huiwen);
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')||(s.charAt(i) >= 'a' &&
                    s.charAt(i) <= 'z')||('0' <= s.charAt(i) && s.charAt(i) <= '9')){
                if (Character.isUpperCase(s.charAt(i))){
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }else {
                    sb.append(s.charAt(i));
                }

            }
        }
//        System.out.println(sb.toString());
        return isHuiwen(sb.toString());
    }
    public boolean isHuiwen(String s){
        int i = 0;
        int j = s.length() - 1;
        while (j > i){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
}
