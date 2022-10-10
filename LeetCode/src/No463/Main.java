package No463;

/**
 * @author ChrisPeng
 * @date 9/26/2022 8:34 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    ans += dfs(i, j, grid, row, col);
            }
        }
        return ans;
    }
    private int dfs(int x, int y, int[][] grid, int n, int m){
        /**
         * 每当在 DFS 遍历中，从一个岛屿方格走向一个非岛屿方格，就将周长加 1
         * **/
        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0)
            return 1;
        if (grid[x][y] == 2)
            return 0;
        grid[x][y] = 2;//方格标记为已访问
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }
}