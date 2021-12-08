package No738;

/**
 * @author ChrisPeng
 * @date 2021/10/20 21:37
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean b = solution.isIncrease(1234);
        int i = solution.monotoneIncreasingDigits(1234);
        System.out.println(i);
    }
}

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
