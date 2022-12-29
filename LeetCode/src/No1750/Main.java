package No1750;

/**
 * @author ChrisPeng
 * @date 2022/12/28 9:39
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumLength("cabaabac");
        System.out.println(i);
    }
}

class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        char left, right;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            left = s.charAt(i);
            right = s.charAt(j);
            while (i < j && s.charAt(i) == left) i ++;
            while (i - 1 < j && s.charAt(j) == right) j --;
        }
        return j - i + 1;
    }
}
