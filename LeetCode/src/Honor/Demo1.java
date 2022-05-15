package Honor;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/4/28 18:59
 */
public class Demo1 {
    public static void main(String[] args) {

    }
}

class GraphNode{
    int[][] matrix = new int[50][50];//adjacency matrix
    int n;//nodes
    int e;//edges
}


class Solution{
    public void problem1(GraphNode g, int[] dist, int[] path, int v0){
//        int i, j, k;
        //初始化赋值
        Boolean[] visited = new Boolean[g.n];
        for (int l = 0; l < g.n; l++) {
            visited[l] = false;
        }

        for (int i = 0; i < g.n; i++) {
            if (g.matrix[v0][i] > 0 && i != v0){
                dist[i] = g.matrix[v0][i];
                path[i] = -v0;
            }else {
                dist[i] = Integer.MAX_VALUE;
                path[i] = -1;
            }
            visited[i] = false;
            path[v0] = v0;
            dist[v0] = 0;
        }
        visited[v0] = true;
        for (int i = 1; i < g.n; i++) {
            int min = Integer.MAX_VALUE;
            int u = 0;
            for (int j = 0; j < g.n; j++) {
                if (visited[j] == false && dist[j] < min){
                    min = dist[j];
                    u = j;
                }
            }
            visited[u] = true;
            for (int k = 0; k < g.n; k++) {
                if (visited[k] == false && g.matrix[u][k] > 0 && (min - 1 +g.matrix[u][k] < dist[k])){
                    dist[k] = min + g.matrix[u][k] - 1;
                    path[k] = u;
                }
            }
        }
    }

    public void showPath(int[] path, int v, int v0){
        Stack<Integer> s = new Stack<>();
        int u = v;
        while (v != v0){
            s.push(v);
            v = path[v];
        }
        s.push(v);
        while (! s.empty()){
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
