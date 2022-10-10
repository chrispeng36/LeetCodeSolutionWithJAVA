package No743;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 9/27/2022 10:12 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[][] arr = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int i = solution1.networkDelayTime(arr, 4, 2);
        System.out.println(i);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0]))
                map.put(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        //记录结点最早收到信号的时间
        int[] r = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            r[i] = Integer.MAX_VALUE;
        }
        r[k] = 0;
        //队列中存放[节点，收到信号的时间]
        ArrayDeque<int[]> s = new ArrayDeque<>();
        s.addLast(new int[]{k, 0});
        while (!s.isEmpty()){
            int[] cur = s.pollFirst();
            if (map.containsKey(cur[0])){
                for (Integer v : map.get(cur[0]).keySet()) {
                    int t = map.get(cur[0]).get(v) + cur[1];
                    if (t < r[v]){
                        r[v] = t;
                        s.addLast(new int[]{v, t});
                    }
                }
            }
        }
        int minT = -1;
        for (int i = 1; i <= n; i++) {
            minT = Math.max(minT, r[i]);
        }
        return minT == Integer.MAX_VALUE ? -1 : minT;
    }
}

class Solution1{
    public int networkDelayTime(int[][] times, int n, int k){
        int[][] graph = new int[n][n];//邻接矩阵
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < times.length; i++) {
            //根据题目的信息初始化图，注意节点从1开始
            int source = times[i][0] - 1;
            int target = times[i][1] - 1;
            graph[source][target] = times[i][2];//表示时间
        }
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];//距离表
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[k - 1] = 0;//初始化起始点K-K的距离为0
        /**接下来是Dijkstra算法的过程**/
        for (int j = 0; j < n; j++) {//一次将一个结点加入路径中
            int cur = -1;
            for (int i = 0; i < n; i++) {//找出距离表中最小的结点，收录结点，即锁死结点，以后不用了
                if (!visited[i] && (cur == -1 || dist[i] < dist[cur]))
                    cur = i;
            }

            visited[cur] = true;//锁死上述找到距离表中最小的结点
            for (int i = 0; i < n; i++) {//更新锁死结点与其相邻结点的dist
                dist[i] = Math.min(dist[i], dist[cur] + graph[cur][i]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE / 2)
                return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}