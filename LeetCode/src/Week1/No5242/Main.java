package Week1.No5242;

/**
 * @author ChrisPeng
 * @date 2022/6/19 10:35
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.greatestLetter("lEeTcOdE");
        System.out.println(s);
    }
}


class Solution {
    public String greatestLetter(String s) {
        //大小写都出现了，并且取字典序最大的
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                lower[s.charAt(i) - 'a'] ++;
            }else {
                upper[s.charAt(i) - 'A'] ++;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (lower[i] > 0 && upper[i] > 0)
                return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}