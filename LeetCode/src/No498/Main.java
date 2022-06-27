package No498;

/**
 * @author ChrisPeng
 * @date 2022/6/14 0:16
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] res = solution.findDiagonalOrder(mat);
        for (int re : res) {
            System.out.println(re);
        }
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        //以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素
        if (mat == null || mat.length == 0)
            return new int[]{};
        int r = 0, c = 0;
        int row = mat.length, col = mat[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            //r + c为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0){
                if (c == col - 1)//撞到了右边界
                    r ++;//往下移动一格准备向下遍历
                else if (r == 0)
                    c ++;//往右移动一格准备向下遍历
                else {//向上移动
                    r --;
                    c ++;
                }
            }else {
                if (r == row - 1)
                    c ++;//往右移动一格准备向上遍历
                else if (c == 0)
                    r ++;//向下移动一格准备向上遍历
                else {//向下移动，斜下方
                    r ++;
                    c --;
                }
            }
        }
        return res;
    }
}
