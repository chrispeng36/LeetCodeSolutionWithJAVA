package No529;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 9/27/2022 8:18 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        /**
         * 给定一个m * n的二维字符矩阵
         * 'M'表示一个未挖出的地雷
         * 'E'表示一个未挖出的空方块
         * 'B'表示没有相邻（上下左右和所有的四个对角线）地雷的已挖出的空白方块
         * 'X'表示一个已挖出的地雷
         */
        int x = click[0], y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else
            dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y){
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length)
                continue;
            //不用判断M，因为有M的话游戏已经结束了
            if (board[tx][ty] == 'M')//记录地雷的个数
                cnt ++;
        }
        if (cnt > 0){
            //规则3，有相邻的被挖出
            board[x][y] = (char) (cnt + '0');
        }else {
            //规则2
            board[x][y] = 'B';//没有相邻地雷的空方块被挖出
            for (int i = 0; i < 8; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                //这里不需要再存在B的时候继续扩展，因为B之前被点击的时候已经被扩展了
                if (tx < 0 || tx >= board.length || ty < 0 || ty>= board[0].length || board[tx][ty] != 'E')
                    continue;
                dfs(board, tx, ty);
            }
        }
    }
}

class Solution1{
    int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else
            bfs(board, x, y);
        return board;
    }
    private void bfs(char[][] board, int sx, int sy){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int cnt = 0, x = pos[0], y = pos[1];
            for (int i = 0; i < 8; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length)
                    continue;
                //不用判断M，因为有的话早就结束了
                if (board[tx][ty] == 'M')
                    cnt ++;
            }
            if (cnt > 0){
                //规则3
                board[x][y] = (char) (cnt + '0');
            }else {
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int tx = x + dx[i];
                    int ty = y + dy[i];
                    //不需要考虑存在B的情况继续扩展，因为B之前被点击的时候已经扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty])
                        continue;
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }
}