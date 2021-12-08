package No859;

/**
 * @author ChrisPeng
 * @date 2021/11/23 0:58
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] split = "aa".split("aa".charAt(0) + "");
//        System.out.println(split.length);
//        for (String s : split) {
////            System.out.println(s);
//            System.out.println("=======================");
//        }
        boolean b = solution.buddyStrings("abcd", "badc");
        System.out.println(b);
    }
}

class Solution {
    public boolean buddyStrings(String s, String goal) {
        //就是判断字符是否存在两个位置的不一样
        if (s.equals(goal)) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.indexOf(s.charAt(i), i + 1) != -1) { //如果A == B，则检查A/B中有无重复字符，如果有，重复字符对调一下就可以，满足条件。
                    return true;
                }
            }
            return false;
        }
        if (s.length() != goal.length())
            return false;
        int count = 0;
        int[] num = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)){
                count ++;
                if (count > 2)
                    return false;
                num[count - 1] = i;
            }
        }
        if (count == 2){
            if (s.charAt(num[0]) == goal.charAt(num[1]) && s.charAt(num[1]) == goal.charAt(num[0]))
                return true;
            else
                return false;
        }
        return false;
    }
}