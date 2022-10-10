package No547;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 9/23/2022 9:55 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        int num = solution.findCircleNum(arr);
        System.out.println(num);
        Solution1 solution1 = new Solution1();
        int num1 = solution1.findCircleNum(arr);
        System.out.println(num1);
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        //其实就是求连通分量的个数
        /**
         * 使用BFS来做的话
         */
        int n = isConnected.length;
        int res = 0;//至少是1
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (! isVisited[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    int j = queue.poll();
                    isVisited[j] = true;
                    for (int k = 0; k < n; k++) {
                        if (isConnected[j][k] == 1 && !isVisited[k])
                            queue.offer(k);
                    }
                }
                res ++;
            }
        }
        return res;
    }
}

class Solution1{
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(isConnected, visited, n, i);
                res ++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int n, int i){
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }
}
