package No131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 9/14/2022 4:31 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.partition("aab");

    }
}

class Solution {
    private boolean[][] f; //表示s[i,...,j]是否为回文
    List<List<String>> ret = new ArrayList<List<String>>();
    int n;
    List<String> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);//初始化所有的值为true
        }
        /**
         * s[i,...,j]为回文，当且仅当其为空串，其长度为1
         * 或者首尾字符相同且s[i + 1, ..., j - 1]为回文字符串
         */
        for (int i = n - 1; i >= 0; --i){
            for (int j = i + 1; j < n; j ++){
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    /**
     * 假设我们当前搜索字符串的第i个字符
     * 且s[0, ..., i - 1]位置的所有字符都已经被分割成若干个回文串
     * 并且分割结果加入到了ans中，那么就要枚举下一个回文串的右边界j
     * 使得s[i,...,j]是一个回文串
     */
    private void dfs(String s, int i){
        if (i == n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        //从i开始从小到大依次枚举j
        for (int j = i; j < n; j++) {
            if (f[i][j]){//判断是否为回文，是的话就加入了
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
