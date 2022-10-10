package No435;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ChrisPeng
 * @date 9/20/2022 11:30 AM
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{2, 3}, {3, 4}, {1, 3}};
        Solution solution = new Solution();
        int i = solution.eraseOverlapIntervals(arr);
        System.out.println(i);
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //给定一个区间集合intervals，返回需要移除区间的最小数量，使得剩余区间互不重叠
        int len = intervals.length;
        if (len == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //按照右边界排序后，优先选择右边界小的区间
        int res = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            //如果上一个区间的右边界小于当前区间的左边界，说明是无交叉的
            if (edge <= intervals[i][0]){
                edge = intervals[i][1];
            }else res ++;
        }
        return res;
    }
}