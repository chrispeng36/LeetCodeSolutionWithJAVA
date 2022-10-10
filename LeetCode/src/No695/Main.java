package No695;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 10/5/2022 12:01 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[][] arr = {{1, 1, 0, 0, 0},
                      {1, 1, 0, 0, 0},
                      {0, 0, 0, 1, 1},
                      {0, 0, 0, 1, 1}};
//        new Solution1()
        int i = solution1.maxAreaOfIsland(arr);
        System.out.println(i);
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(dfs(grid, i, j), max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }
}


class Solution1{
    int[] di = {0, 0, 1, -1};
    int[] dj = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid){
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = 0;
                if (grid[i][j] == 1 && !visited[i][j]){
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] temp = queue.poll();
                        int cur_i = temp[0], cur_j = temp[1];
                        cur ++;
                        visited[cur_i][cur_j] = true;
                        for (int k = 0; k < 4; k++) {
                            int next_i = cur_i + di[k], next_j = dj[k] + cur_j;
                            if (next_i >= 0 && next_i < n && next_j >= 0 && next_j < m && grid[next_i][next_j] == 1 && !visited[next_i][next_j]){
                                queue.offer(new int[]{next_i, next_j});
                                visited[next_i][next_j] = true;
                            }
                        }
                    }

                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}