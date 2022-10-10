package Huawei.Demo2;

import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/21/2022 7:40 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//行数
        int n = scanner.nextInt();//列数
        char[][] cheers = new char[m][n];
        for (int i = 0; i < m; i++) {
            //每行的单元格对应的标志
            String temp = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                cheers[i][j] = temp.charAt(j);
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 0;

    }
}
