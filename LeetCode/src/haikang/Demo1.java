package haikang;

/**
 * @author ChrisPeng
 * @date 2022/4/17 10:57
 */
public class Demo1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.digitSum("11111222223", 3);
        System.out.println(s);
    }
}

class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k)
            return s;
        int len = s.length();
        String sb = "";
        for (int i = 0; i < len; i += k) {
            int tempSum = 0;
            for (int j = i; j < i + k; j++) {
                if (j >= len) break;
                else
                    tempSum += (s.charAt(j) - '0');
            }
            sb += tempSum;
        }
//        System.out.println(sb);
        String res = digitSum(sb, k);
        return res;
    }
}
