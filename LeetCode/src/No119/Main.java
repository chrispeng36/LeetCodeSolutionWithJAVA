package No119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 9/13/2022 2:40 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (Integer integer : solution.getRow(3)) {
            System.out.println(integer);
        }

    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        /**
         * 第index行应该有index+1个元素
         * 除开dp[0]和dp[rowIndex]之外的元素都是
         * dp[i] = arr[i] + arr[i-1]
         */
//        if (rowIndex == 0)
//            return new ArrayList<>(Arrays.asList(1));
//        if (rowIndex == 1)
//            return new ArrayList<>(Arrays.asList(1,1));
//        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
//        for (int i = 0; i < rowIndex + 1; i++) {
//            dp[i][0] = 1;
//            dp[i][i] = 1;
//        }
//        for (int i = 2; i < rowIndex + 1; i++) {
//            for (int j = 1; j <= i - 1; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
//            }
//        }
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < rowIndex + 1; i++) {
//            res.add(dp[rowIndex][i]);
//        }
//        return res;

        /**
         * 获取杨辉三角的指定行
         * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
         * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
         */
        ArrayList<Integer> list = new ArrayList<>();
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            list.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return list;
    }
}