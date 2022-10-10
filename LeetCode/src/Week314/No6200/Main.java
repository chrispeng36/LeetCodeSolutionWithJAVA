package Week314.No6200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ChrisPeng
 * @date 2022/10/9 10:31
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        int i = solution.hardestWorker(10, arr);
        System.out.println(i);
    }
}

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int[][] times = new int[logs.length][2];
        for (int i = 0; i < logs.length; i++) {
            if (i == 0){
                times[i][0] = logs[i][0];//表示员工
                times[i][1] = logs[i][1];//表示时间
            }else {
                times[i][0] = logs[i][0];//表示员工
                times[i][1] = logs[i][1] - logs[i - 1][1];//表示时间
            }
        }
        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]){
                return o2[0] - o1[0];
            }else {
                return o1[1] - o2[1];
            }
        });
        return times[times.length - 1][0];
    }
}
