package No1971;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/12/19 13:29
 */
public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 广度优先搜索
 */
//class Solution {
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        List<Integer>[] adj = new List[n];//存储结点->连接结点的列表
//        for (int i = 0; i < n; i++) {
//            adj[i] = new ArrayList<Integer>();
//        }
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1];
//            adj[x].add(y);
//            adj[y].add(x);
//        }
//        boolean[] visited = new boolean[n];
//        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        queue.offer(source);
//        visited[source] = true;
//        while (!queue.isEmpty()) {
//            int vertex = queue.poll();
//            if (vertex == destination) {
//                break;
//            }
//            for (Integer next : adj[vertex]) {
//                if (!visited[next]) {
//                    queue.offer(next);
//                    visited[next] = true;
//                }
//            }
//        }
//        return visited[destination];
//    }
//}

/**
 * 深度优先搜索
 */
//class Solution {
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        List<Integer>[] adj = new List[n];
//        for (int i = 0; i < n; i++) {
//            adj[i] = new ArrayList<>();
//        }
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1];
//            adj[x].add(y);
//            adj[y].add(x);
//        }
//        boolean[] visited = new boolean[n];
//        return dfs(source, destination, adj, visited);
//    }
//
//    public boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
//        if (source == destination)
//            return true;
//        visited[source] = true;
//        for (Integer next : adj[source]) {
//            if (!visited[next] && dfs(next, destination, adj, visited))
//                return true;
//        }
//        return false;
//    }
//}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.connect(source, destination);
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx] ++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}