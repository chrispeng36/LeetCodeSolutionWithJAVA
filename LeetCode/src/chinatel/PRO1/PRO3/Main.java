package chinatel.PRO1.PRO3;

import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 2022/6/5 19:41
 */
public class Main {
    public static void main(String[] args) {
        //力臂长度15,1<=G<=20，需要使用所有砝码
        //C表示吊钩的重新分配，每个数字表示相对于x轴上天平中心的位置
        //-表示左臂，+表示右臂
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] c = new int[n];
            int[] g = new int[m + 1];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }

            for (int i = 1; i <= m; i++) {
                g[i] = scanner.nextInt();
            }

            int[][] dp = new int[m + 1][15001];
            dp[0][7500] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < 15001; j++) {
                    for (int k = 0; k < n; k++) {
                        int val = j - c[k] * g[i];//M = F * L
                        if (val >= 0 && val < 15001)
                            dp[i][j] += dp[i - 1][val];
                    }
                }
            }
            System.out.println(dp[m][7500]);
        }

    }
}
