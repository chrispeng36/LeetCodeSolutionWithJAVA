package No2133;

import java.util.HashSet;

/**
 * @author ChrisPeng
 * @date 2022/1/21 16:52
 */
public class Demo {
    public static void main(String[] args) {

    }
}
class Solution {
    public boolean checkValid(int[][] matrix) {
        //如果一个元素和周围的元素存在相等的，那么可以确定的是，这个矩阵不可能满足要求
        int n = matrix.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set1.add(matrix[i][j]);
                set2.add(matrix[j][i]);
            }
            if (set1.size() != n || set2.size() != n)
                return false;
            set1.clear();
            set2.clear();
        }
        return true;
    }
}