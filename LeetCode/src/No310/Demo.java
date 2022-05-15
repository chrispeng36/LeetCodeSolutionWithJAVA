package No310;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/4/6 9:21
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /**
         * 叶子节点的度为1，非叶子节点的度至少为2
         * 树的高度由根节点到叶子节点的最大距离决定
         * dist[x][y]表示从节点x到节点y的距离，假设树中距离最长的两个节点为(x,y)
         * 他们之间的距离为maxdict = dist[x][y]
         * 可以推出任意的节点构成的树最小高度为minheight=[maxdist/2]取上界
         * 且最小高度的树根节点一定在节点x到节点y的路径上。
         */
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, adj);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(u);
        visit[u] = true;
        int node = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    queue.offer(v);
                }
            }
        }
        return node;
    }

}