package Classical_problems.maze_DFS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/22/2022 9:49 PM
 */
public class Main {
    static int m;
    static int n;
    static int start_x;
    static int start_y;
    static int end_x;
    static int end_y;
    static int min;
    static boolean[][] visited;
    static int[][] maze;

    public static void main(String[] args) {
        /**
         * 输入格式：
         * 第一行：表示迷宫的行数和列数的n和m
         * 第二行：起点和终点(x0,y0)，(x1,y1)
         * 接下来的n行，输入迷宫的形状
         */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//表示迷宫的行数
        m = scanner.nextInt();//表示迷宫的列数
        start_x = scanner.nextInt();
        start_y = scanner.nextInt();
        end_x = scanner.nextInt();
        end_y = scanner.nextInt();
        min = Integer.MAX_VALUE;
        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        //首先需要一个数组来某个点是否已经访问过
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        visited[start_x][start_y] = true;
        dfs(start_x, start_y, 0);
        System.out.println(min);
    }

    public static void dfs(int x, int y, int step) {
        if (x == end_x && y == end_y) {
            if (step < min)
                min = step;
            return;//回溯
        }
        //右下左上的试探
        //右
        if (y + 1 < m && maze[x][y + 1] == 1 && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(x, y + 1, step + 1);
            visited[x][y + 1] = false;//回退回来之后设置为未访问
        }
        //下
        if (x + 1 < n && maze[x + 1][y] == 1 && !visited[x + 1][y]){
            visited[x + 1][y] = true;
            dfs(x + 1, y, step + 1);
            visited[x + 1][y] = false;
        }
        //左
        if (y - 1 >= 0 && maze[x][y - 1] == 1 && ! visited[x][y - 1]){
            visited[x][y - 1] = true;
            dfs(x, y - 1, step + 1);
            visited[x][y - 1] = false;
        }
        //上
        if (x - 1 >= 0 && maze[x - 1][y] == 1 && !visited[x - 1][y]){
            visited[x - 1][y] = true;
            dfs(x - 1, y, step + 1);
            visited[x - 1][y] = false;
        }
        return;//回退
    }
}
