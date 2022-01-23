package No1332;

/**
 * @author ChrisPeng
 * @date 2022/1/22 21:54
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ababa = solution.removePalindromeSub("ababa");
        System.out.println(ababa);
    }
}

class Solution {
    public int removePalindromeSub(String s) {
        int left = 0;int right = s.length() - 1;
        while (right > left){
            if (s.charAt(left) != s.charAt(right))
                break;
            else {
                left ++;
                right --;
            }
        }
        return right > left ? 2 : 1;
    }
}