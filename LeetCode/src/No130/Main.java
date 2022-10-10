package No130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 9/23/2022 3:03 PM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] dx = {1, -1, 0, 0};//分别表示右左下上
    int[] dy = {0, 0, 1, -1};
    public void solve(char[][] board) {
        /**
         * 任何不存在于边界上或者不与边界上的'O'相连的'O'
         * 最终都会被填充为X
         */
        //首先用一个list存储所有在边界上或者与边界上的O相连的O
        int n = board.length;
        if (n == 0)
            return;
        int m = board[0].length;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O'){
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';//表示标记过的字母
            }
            if (board[i][m - 1] == 'O'){
                queue.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'A';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O'){
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O'){
                queue.offer(new int[]{n - 1, i});
                board[n - 1][i] = 'A';
            }
        }
        /**做试探，BFS看是否有与queue中直接相连的结点**/
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my < 0 || my >= m || mx >= n || board[mx][my] != 'O')
                    continue;
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}


class Solution1 {
    int n, m;
    public void solve(char[][] board){
        //如果要用DFS做的话
        n = board.length;
        if (n == 0)
            return;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int x, int y){
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O')
            return;//回溯
        board[x][y] = 'A';
        /**往四个方向进行回溯**/
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}