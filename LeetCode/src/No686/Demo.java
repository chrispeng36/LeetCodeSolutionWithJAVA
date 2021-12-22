package No686;

/**
 * @author ChrisPeng
 * @date 2021/12/22 9:26
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab","ba");
        System.out.println(i);
    }
}

class Solution {
    public int repeatedStringMatch(String a, String b) {
        /**
         * 给定两个字符串a和b，寻找重复叠加字符串a的最小次数
         * 使得字符串b成为叠加后的字符串a的子串，如果不存在就返回-1
         */

//        if (a.equals(b) || a.contains(b))
//            return 1;
//        String strTemp = a;
//        boolean fllag = false;
//        int count = 1;
//        while (strTemp.length() <= 2 * a.length() + b.length()){
//            strTemp += a;
//            count ++;
//            if (strTemp.contains(b)){
//                fllag = true;
//                break;
//            }
//        }
//        return fllag ? count : -1;
        boolean[]set = new boolean[26];
        for (char ch : a.toCharArray()) {
            set[ch - 'a'] = true;
        }
        for (char ch : b.toCharArray()) {
            if(!set[ch - 'a']) {
                return -1;
            }
        }
        int k = b.length() / a.length();
        StringBuilder str = new StringBuilder(a.repeat(k));
        for (int i = 0; i < 3; i++) {
            if (str.toString().contains(b)) {
                return k + i;
            }
            str.append(a);
        }
        return -1;
    }
}