package JianzhiofferII002;

/**
 * @author ChrisPeng
 * @date 2021/10/14 21:40
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addBinary("10110", "1101");
        System.out.println(s);
    }
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0,i = a.length() - 1,j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0){
            int res = carry;
            if (i >= 0){
                res += a.charAt(i) - '0';
                i --;
            }
            if (j >= 0)
                res += b.charAt(j --) - '0';
            stringBuilder.append(res % 2);
            carry = res / 2;
        }
        return stringBuilder.reverse().toString();
    }
}
