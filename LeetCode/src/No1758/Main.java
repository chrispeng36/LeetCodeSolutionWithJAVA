package No1758;

/**
 * @author ChrisPeng
 * @date 2022/11/29 15:46
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minOperations("1111");
        System.out.println(i);
    }
}

class Solution {
    public int minOperations(String s) {
        //变成交替字符串所需的最少操作数
        int len = s.length();
        char[] situation1 = new char[len];
        situation1[0] = '0';
        char[] situation2 = new char[len];
        situation2[0] = '1';
        int res1 = 0, res2 = 0;//记录情况1,2的需要修改的次数
        if (s.charAt(0) == '0') res2 ++;
        else res1 ++;
        for (int i = 1; i < len; i++) {
            situation1[i] = situation1[i - 1] == '0' ? '1' : '0';
            situation2[i] = situation2[i - 1] == '0' ? '1' : '0';
            if (s.charAt(i) != situation1[i]) res1 ++;
            if (s.charAt(i) != situation2[i]) res2 ++;
        }
        return Math.min(res1, res2);
    }
}
