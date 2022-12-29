package No787;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/12/19 18:15
 */
public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 超时了
 */
//class Solution {
//    int n, k, src, dst;
//    int minCost = Integer.MAX_VALUE;
//    List<List<int[]>> edges;
//
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        this.n = n;
//        this.k = k;
//        this.dst = dst;
//        this.src = src;
//        edges = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            edges.add(new ArrayList<>());
//        }
//        for (int[] flight : flights) {
//            int source = flight[0], destination = flight[1], cost = flight[2];
//            edges.get(source).add(new int[]{destination, cost});
//        }
//        dfs(0, src, 0);
//        return minCost == Integer.MAX_VALUE ? -1 : minCost;
//    }
//
//    private void dfs(int steps, int currentNode, int currentCost) {
//        if (currentNode == dst) {
//            //到达目的地
//            minCost = Math.min(minCost, currentCost);
//            return;
//        }
//        if (steps > k || currentCost >= minCost) {
//            return;
//        }
//        List<int[]> ints = edges.get(currentNode);
//        for (int[] current : ints) {
//            dfs(steps + 1, current[0], currentCost + current[1]);
//        }
//    }
//}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        //f[t][i]表示恰好经过t次航班，从出发城市到城市i需要的最小花费
        //最多能中转k次，那么最多搭乘k + 1次航班
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;//限制了从src点开始
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {//遍历所有的航班
                int j = flight[0], i = flight[1], cost = flight[2];
                //f[t - 1][j] + cost表示到达j点经过1步，也就是邻居了
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int i = 1; i <= k + 1; i++) {
            ans = Math.min(ans, f[i][dst]);
        }
        return ans == INF ? -1 : ans;
    }
}
