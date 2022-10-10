package Mianshi01_08;

/**
 * @author ChrisPeng
 * @date 9/30/2022 11:15 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0,1,2,0},{3, 4, 5, 2}, {1, 3, 1,5}};
        solution.setZeroes(arr);
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        boolean[][] isChanged = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isChanged[i][j])
                    continue;
                if (matrix[i][j] == 0){
                    //把行和列都改为0
                    for (int k = 0; k < M; k++) {
                        if (matrix[k][j] != 0)
                            isChanged[k][j] = true;
                        matrix[k][j] = 0;
                    }
                    for (int k = 0; k < N; k++) {
                        if (matrix[i][k] != 0)
                            isChanged[i][k] = true;
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }
}
