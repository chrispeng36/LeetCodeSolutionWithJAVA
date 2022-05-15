package Jianzhiofferii035;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/2/16 16:45
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> list = new ArrayList<>();
        list.add("23:59");list.add("00:00");
        int i = solution.findMinDifference(list);
        System.out.println(i);
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 24 * 60)
            return 0;
        ArrayList<Integer> mins = new ArrayList<>();
        for (String t : timePoints) {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int res = 24 * 60;
        for (int i = 1; i < mins.size(); i++) {
            res = Math.min(res,mins.get(i) - mins.get(i - 1));
        }
        return res;
    }
}