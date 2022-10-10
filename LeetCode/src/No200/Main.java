package No200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/6/19 16:37
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int i = solution.numIslands(grid);
        System.out.println(i);
    }
}

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int numIslands(char[][] grid) {
        //这个题目也是来计算连通分量的
        LinkedList<int[]> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        int res = 0;
        boolean[][] isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]){
                    res ++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] cell = queue.poll();
                        int cur_x = cell[0], cur_y = cell[1];
                        for (int k = 0; k < 4; k++) {
                            int mx = cur_x + dx[k], my = cur_y + dy[k];
                            if (mx < 0 || my < 0 || mx > n || my > m || grid[mx][my] != '1')
                                continue;
                            if (!isVisited[mx][my] && grid[mx][my] == '1'){
                                queue.add(new int[]{mx, my});
                                isVisited[mx][my] = true;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}

class Solution1{
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int numIslands(char[][] grid){
        int n = grid.length, m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1'){
                    res ++;//未访问过就+1
                    dfs(grid, isVisited, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] isVisited, int x, int y){
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || mx >= n || my < 0 || my >= m)
                continue;
            if (!isVisited[mx][my] && grid[mx][my] == '1'){
                isVisited[mx][my] = true;
                dfs(grid, isVisited, mx, my);
            }
        }
    }
}