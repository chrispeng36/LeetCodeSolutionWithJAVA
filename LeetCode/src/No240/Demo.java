package No240;

/**
 * @author ChrisPeng
 * @date 2021/10/25 0:34
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        boolean b = solution.searchMatrix(arr, 5);
        System.out.println(b);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从左到右上升，从上到下上升
        //相当于在二维数组中找到指定的元素
        int lenOut = matrix.length;
        int lenIn = matrix[0].length;
        //首先找在第几行、
        if (lenIn == 0 || lenOut == 0)
            return false;
        int i = lenOut - 1;
        int j = 0;
        while (i >= 0 && j < lenIn){
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                j = j + 1;
            else
                i = i - 1;
        }
        return false;
    }
}