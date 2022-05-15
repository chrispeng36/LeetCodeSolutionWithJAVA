package LeetCode_DP.No474;

/**
 * @author ChrisPeng
 * @date 2022/5/5 19:48
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"10", "0001", "111001", "1", "0"};
        int maxForm = solution.findMaxForm(strings, 5, 3);
        System.out.println(maxForm);
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //给定二进制的字符串数组，两个整数m和n
        //找出并返回strs的最大子集长度，该子集中最多有m个0和n个1
        /**
         * dp[i,j]表示最多有i个0和j个1的strs的最大子集的大小
         * 递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
         * 初始化为0
         */
//        int[][] dp = new int[m + 1][n + 1];
//        int oneNum, zeroNum;
//        for (String str : strs) {
//            oneNum = 0;
//            zeroNum = 0;
//            for (char ch : str.toCharArray()) {
//                if (ch == '0')
//                    zeroNum++;
//                else
//                    oneNum++;
//            }
//
//            for (int i = m; i >= zeroNum; i--) {//相当于有俩背包，一个背包装0，一个背包装1
//                for (int j = n; j >= oneNum; j--) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
//                }
//            }
//        }
//        return dp[m][n];

        /**dp表示的是最多有i个0和j个1的strs的最大子集的大小**/
        int[][] dp = new int[m + 1][n + 1];
        /**
         * 这里有两个背包，一个装0，一个装1
         *
         */
        int zeroNum, oneNum;
        for (String str : strs) {
            zeroNum = 0;
            oneNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0')
                    zeroNum ++;
                else
                    oneNum ++;
            }
            /**统计到了1和0的个数，针对单个字符串
             * 背包应该是倒序遍历的
             * dp更新的公式意思是：
             * 加上当前的字符串，如果子集的数目更多的话，那么就更新，当然i的数量必须大于当前的0的数量，j也是一样
             * **/
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
