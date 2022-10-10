package Huawei.Demo3;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 9/21/2022 7:58 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trees_count = scanner.nextInt();
        int[] postion = new int[trees_count];
        int[] radius = new int[trees_count];
        int[] values = new int[trees_count];
        for (int i = 0; i < trees_count; i++) {
            postion[i] = scanner.nextInt();
        }
        for (int i = 0; i < trees_count; i++) {
            radius[i] = scanner.nextInt();
        }
        for (int i = 0; i < trees_count; i++) {
            values[i] = scanner.nextInt();
        }
        int[][] lance = new int[trees_count][3];
        for (int i = 0; i < trees_count; i++) {
            lance[i][0] = postion[i] - radius[i];//表示左边界
            lance[i][1] = postion[i] + radius[i];//表示右边界
            lance[i][2] = values[i];//表示经济价值
        }
        /**
         * dp[i][0]表示不栽当前树可以获得的最大的价值
         * dp[i][1]表示载种当前树可以获得的最大的价值
         */
        int[][] dp = new int[trees_count][2];
        dp[0][0] = lance[0][2];
        dp[0][1] = 0;
        int res = 0;
        for (int i = 1; i < trees_count; i++) {
            int tempValue = 0;
            for (int j = 0; j < i; j++) {//遍历之前的树
                if (lance[j][1] <= lance[i][0])//表示可以载种当前树
                    tempValue = Math.max(tempValue, dp[j][0]);//载种当前树的前提下载种i树的价值
            }
            dp[i][0] = tempValue + lance[i][2];//种这个树的价值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);//不种这个树的价值，前面那个位置随意了
            res = Math.max(Math.max(res, dp[i][0]), dp[i][1]);
        }
        System.out.println(res);
    }
}
