package No97;

/**
 * @author ChrisPeng
 * @date 9/12/2022 12:11 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        /**
         * f[i][j]表示的是s1的前i个元素和s2的前j个元素是否能够交错组成s3的前i+j个元素。
         * 可以写出公式：
         * f(i,j) = [f(i - 1, j) and s1(i - 1) == s3(p)] || [f(i, j - 1) and s2(j - 1) == s3(p)]
         * p = i + j - 1
         */
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int p = i + j - 1;
                if (i > 0)
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                if (j > 0)
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return f[len1][len2];
    }
}
