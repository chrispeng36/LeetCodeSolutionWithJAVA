package WeekendContests.No310.No6178;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ChrisPeng
 * @date 9/11/2022 11:11 AM
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        /**
         * 两个区域是否会相交取决于前一个区间的end和后一个区间的start
         * 维护一个区间end值的优先队列，每次添加一个新的区间时，贪心的选择最小的那个end值进行判断
         * start > end 则可以加入该分组，并更新分组的末尾
         * 若start <= end则不可以加入任何分组，直接重新开一个分组，将对应的end加入
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });//按照end从小到大排序，如果end一样则比较start
        int m = intervals.length;

        for (int[] interval : intervals) {
            //当前请求加入的分组
            int start = interval[0], end = interval[1];
            if (pq.isEmpty()) pq.offer(end);
            else {
                if (start <= pq.peek()){
                    //当不可加入已有分组的时候，直接以end新建分组
                    pq.add(end);
                }else {//可以加入时，加入其中并更新区间end
                    pq.poll();
                    pq.offer(end);
                }
            }
        }
        return pq.size();
    }
}