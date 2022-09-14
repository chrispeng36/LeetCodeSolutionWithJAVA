//package meituan.Demo4;
//
//import java.util.Scanner;
//
///**
// * @author ChrisPeng
// * @date 9/3/2022 10:05 AM
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();//城市数量
//        int m = scanner.nextInt();//总天数
//        int k = scanner.nextInt();//初始所在的城市
//        int[] task_place = new int[m];//表示第i天的任务所在的地点
//        int[] profit_unchange = new int[m];//表示第i天任务地点不变的收益
//        int[] profit_change = new int[m];//表示第i天任务地点改变的收益
//        for (int i = 0; i < m; i++) {
//            task_place[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < m; i++) {
//            profit_unchange[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < m; i++) {
//            profit_change[i] = scanner.nextInt();
//        }
//        /**第i天可以选择有两个
//         * 完成任务，根据当前的位置
//         * 不完成任务：收益为0
//         * 最大收益=完成任务
//         */
//        //dp[i]表示第i天的最大的收益
//        int[] dp = new int[m + 1];
//        //初始化？
//        dp[0] = 0;
//        int curr_place = k;
//        for (int i = 0; i < m; i++) {
//            dp[i] =
//        }
//    }
//}
