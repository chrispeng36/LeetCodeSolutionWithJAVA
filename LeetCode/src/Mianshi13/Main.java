package Mianshi13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 10/5/2022 8:07 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.movingCount(11, 8, 16);
        System.out.println(i);
    }
}

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int movingCount(int m, int n, int k) {
        /**
         * m * n的方格
         * 从(0, 0)出发，不能移动到方格外
         * 也不能移动到坐标各个位之和大于K的
         */
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int res = 0;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cur_x = temp[0], cur_y = temp[1];
            res++;
            for (int i = 0; i < 4; i++) {
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];
                if (next_x >= m || next_x < 0 || next_y >= n || next_y < 0 || visited[next_x][next_y] || next_x + next_y > k + 1)
                    continue;
                queue.offer(new int[]{next_x, next_y});
                visited[next_x][next_y] = true;
            }
        }
        return res;
    }
}

class Solution1 {
    public int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (i % 10 + i / 10 + j % 10 + j / 10) > k)
            return 0;
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) +
                dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) +
                dfs(i, j - 1, m, n, k, visited);
    }
}