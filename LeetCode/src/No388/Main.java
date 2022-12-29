package No388;

/**
 * @author ChrisPeng
 * @date 2022/12/29 11:42
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int lengthLongestPath(String input) {
        //用level[i]保存当前已遍历路径中第i层目录的长度
        /**
         * 1. 当前文件绝对路径就等于当前路径中第depth - 1层的绝对路径加上/，再加上当前路径名
         *  也就是level[depth - 1] + 1 + lp
         * 2. 在向下进行遍历第i层目录的时候，前i-1层的目录路径不会发生改变
         * 3. 只需要保存文件路径长度而不需要保存文件路径
         */
        int n = input.length();
        int pos = 0, ans = 0;
        int[] level = new int[n + 1];

        while (pos < n) {
            //检测当前文件的深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos ++;
                depth ++;
            }
            //统计当前文件名的长度
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) !=  '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len ++;
                pos ++;
            }
            //跳过换行符
            pos ++;
            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }
}
