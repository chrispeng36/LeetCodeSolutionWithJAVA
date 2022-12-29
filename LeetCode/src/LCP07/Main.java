package LCP07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/12/22 15:13
 */
public class Main {
    public static void main(String[] args) {

    }
}

//class Solution {
//    int ways, n, k;
//    List<List<Integer>> edges;
//
//    public int numWays(int n, int[][] relation, int k) {
//        ways = 0;
//        this.n = n;
//        this.k = k;
//        edges = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            edges.add(new ArrayList<>());
//        }
//        for (int[] edge : relation) {
//            int src = edge[0], dst = edge[1];
//            edges.get(src).add(dst);
//        }
//        dfs(0, 0);
//        return ways;
//    }
//
//    public void dfs(int index, int steps) {
//        if (steps == k) {
//            if (index == n - 1) {
//                ways ++;
//            }
//            return;
//        }
//        List<Integer> list = edges.get(index);
//        for (Integer nextIndex : list) {
//            dfs(nextIndex, steps + 1);
//        }
//    }
//}

class Solution {
    public int numWays(int n, int[][] relation,  int k) {
        /**
         * 使用dp思想来解决
         * dp[i][j]表示的是经过i轮传递到编号j玩家的方案数
         * dp[0][j]只有在j=0的时候是1，其他情况为0
         *
         */
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}