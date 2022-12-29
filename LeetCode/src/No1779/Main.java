package No1779;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ChrisPeng
 * @date 2022/12/1 8:05
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE, idx = -1;

        int n = points.length;

        for (int i = 0; i < n; i++) {
            if (points[i][0] != x && points[i][1] != y) continue;
            int t = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
            if (t < ans) {
                ans = t;
                idx = i;
            }
        }

        return idx;
    }
}