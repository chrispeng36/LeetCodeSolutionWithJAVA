package No436;

import java.util.Arrays;

/**
 * @author ChrisPeng
 * @date 2022/5/20 10:15
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int m = intervals.length, n = intervals[0].length;
        int[][] starts = new int[m][n];
        for (int i = 0; i < m; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        Arrays.sort(starts, (x, y) -> x[0] - y[0]);
        int[] ret = new int[m];
        for (int i = 0; i < m; i++) {
            int end = intervals[i][1], left = 0, right = m - 1;
            while (left < right){
                int mid = left + right >> 1;
                if (end > starts[mid][0]) left = mid + 1;
                else right = mid;
            }
            ret[i] = starts[right][0] < end ? -1 : starts[right][1];
        }
        return ret;
    }
}