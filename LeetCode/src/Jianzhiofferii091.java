///**
// * @author ChrisPeng
// * @date 2022/6/25 11:16
// */
//public class Jianzhiofferii091 {
//    public static void main(String[] args) {
//
//    }
//}
//
//class Solution {
//    public int minCost(int[][] costs) {
//        //每个房子被粉刷成红蓝绿三种，粉刷所有房子并使得相邻的房子的颜色不能相同
//        int n = costs.length;
//        int[][] ans = new int[n + 1][3];//表示粉刷第0号房子到第i号房子被粉刷成第j种颜色的最小花费成本
//        for (int i = 1; i <= n; i++) {//当前粉刷的颜色，前面的取其他两种中的最小的
//            ans[i][0] = Math.min(ans[i - 1][1], ans[i - 1][2]) + costs[i - 1][0];
//            ans[i][1] = Math.min(ans[i - 1][2], ans[i - 1][0]) + costs[i - 1][1];
//            ans[i][2] = Math.min(ans[i - 1][1], ans[i - 1][0]) + costs[i - 1][2];
//        }
//        return Math.min(Math.min(ans[n][0], ans[n][1]), ans[n][2]);
//    }
//}