package No318;

/**
 * @author ChrisPeng
 * @date 2021/11/17 0:04
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int i = solution.maxProduct(arr);
        System.out.println(i);
    }
}

class Solution {
    public int maxProduct(String[] words) {
        /**
         * 找到两个元素长度相乘的最大值
         * 并且两个元素中不包含公共字符
         * 不存在的话就返回0
         */

        int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        //用移位1来记录出现了哪一位字符，一共最多32位
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hash[i] & hash[j]) == 0)
                    max = Math.max(words[i].length()*words[j].length(),max);
            }
        }
        return max;
    }
}