package No1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/7/20 14:20
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] nums = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                k %= nums.length;
                nums[k ++] = grid[i][j];
            }
        }
        k = 0;
        ArrayList<List<Integer>> lists = new ArrayList<>(grid.length);
        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> tempList = new ArrayList<>(grid[0].length);
            for (int j = 0; j < grid[0].length; j++) {
                tempList.add(nums[k++]);
            }
            lists.add(tempList);
        }
        return lists;
    }
}
