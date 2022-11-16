package No733;

import java.util.ArrayDeque;

/**
 * @author ChrisPeng
 * @date 2022/10/25 17:25
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ints = solution.floodFill(arr, 1, 1, 2);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        /**
         * 首先考虑BFS怎么做
         */
        int m = image.length, n = image[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.push(new int[]{sr, sc});
        visited[sr][sc] = true;
        int originColor = image[sr][sc];
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] cell = queue.pop();
            int curX = cell[0], curY = cell[1];
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i], newY = curY + dy[i];
                if (newX < m && newX >= 0 && newY < n && newY >= 0 && !visited[newX][newY] && image[newX][newY] == originColor) {
                    queue.push(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    image[newX][newY] = color;
                }
            }
        }
        return image;
    }
}

class Solution1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image, sr, sc, color, image[sr][sc]);
    }

    private int[][] dfs(int[][] image, int i, int j, int newColor, int originColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || image[i][j] != originColor) {

        } else {
            int temp = image[i][j];
            image[i][j] = newColor;
            dfs(image, i + 1, j, newColor, temp);
            dfs(image, i - 1, j, newColor, temp);
            dfs(image, i, j + 1, newColor, temp);
            dfs(image, i, j - 1, newColor, temp);

        }
        return image;
    }
}
