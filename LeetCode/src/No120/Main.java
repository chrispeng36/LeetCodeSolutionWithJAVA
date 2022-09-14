package No120;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 9/9/2022 4:10 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * f[i][j]表示从三角形顶部走到位置(i, j)的最小路径和
         * 想要走到(i, j)，上一步就必须是(i - 1, j - 1)或者(i - 1, j)
         * 故f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]
         * 第i行有i+1个元素，对应于J的范围为[0,i]
         * f[i][0]=f[i−1][0]+c[i][0]
         * f[i][i]=f[i−1][i−1]+c[i][i]
         * f[0][0]=c[0][0]
         */
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}