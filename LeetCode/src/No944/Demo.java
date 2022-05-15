package No944;

/**
 * @author ChrisPeng
 * @date 2022/5/12 10:12
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"abc", "bce", "cae"};
        int i = solution.minDeletionSize(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int len = strs.length;
        int str_len = strs[0].length();

        if (len == 1)
            return 0;
        for (int i = 0; i < str_len; i++) {
            for (int j = 1; j < len; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    res ++;
                    break;
                }
            }
        }
        return res;
    }
}