package No1784;

/**
 * @author ChrisPeng
 * @date 10/4/2022 11:12 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkOnesSegment("1");
        System.out.println(b);
    }
}

class Solution {
    public boolean checkOnesSegment(String s) {
        int first_zero = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                first_zero = i;
                break;
            }
        }
        for (int i = first_zero + 1; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                return false;
        }
        return true;
    }
}
