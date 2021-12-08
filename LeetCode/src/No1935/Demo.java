package No1935;

/**
 * @author ChrisPeng
 * @date 2021/10/14 16:09
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.canBeTypedWords("hello world", "l");
        System.out.println(i);
    }
}

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");
        char[] chars = brokenLetters.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (s[i].contains(chars[j]+"")) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count ++;
        }
        return count;
    }
}