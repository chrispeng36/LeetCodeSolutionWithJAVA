package Classical_problems.maze;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 9/22/2022 7:54 PM
 */
public class Main {
    static class Nodes{
        int x;
        int y;
        int step;

        public Nodes(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public static void main(String[] args) {
        /**
         * 输入格式：
         * 第一行：表示迷宫的行数和列数的n和m
         * 第二行：起点和终点(x0,y0)，(x1,y1)
         * 接下来的n行，输入迷宫的形状
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//表示迷宫的行数
        int m = scanner.nextInt();//表示迷宫的列数
        int start_x = scanner.nextInt();
        int start_y = scanner.nextInt();
        int end_x = scanner.nextInt();
        int end_y = scanner.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        //首先需要一个数组来某个点是否已经访问过
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        Nodes start_node = new Nodes(start_x, start_y, 0);
        LinkedList<Nodes> queue = new LinkedList<>();//用个队列
        int[] dx = {0, 1, 0, -1};//表示右下左上x的变化
        int[] dy = {1, 0, -1, 0};
        queue.add(start_node);
        visited[0][0] = true;
        boolean flag = false;
        while (!queue.isEmpty()){
            int cur_x = queue.getFirst().x;
            int cur_y = queue.getFirst().y;
            if (cur_x == end_x && cur_y == end_y){
                System.out.println(queue.getFirst().step);
                flag = true;
                break;
            }

            //接下来进行BFS试探
            for (int i = 0; i < 4; i++) {
                int new_x = cur_x + dx[i];
                int new_y = cur_y + dy[i];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && maze[new_x][new_y] == 1 && !visited[new_x][new_y]){
                    Nodes new_node = new Nodes(new_x, new_y, queue.getFirst().step + 1);
                    queue.add(new_node);
                    visited[new_x][new_y] = true;
                }
            }
            queue.removeFirst();//删除队首
        }
        if (!flag) System.out.println(-1);
    }
}
