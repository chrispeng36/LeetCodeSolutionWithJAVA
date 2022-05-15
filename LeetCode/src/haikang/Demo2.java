package haikang;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/4/17 11:19
 */
public class Demo2 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        int i = solution1.minimumRounds(tasks);
        System.out.println(i);
    }
}
class Solution1 {
    public int minimumRounds(int[] tasks) {
        //每一轮可以完成2个或者三个相同的任务
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i]))
                map.put(tasks[i],map.get(tasks[i]) + 1);
            else
                map.put(tasks[i], 1);
        }
        int res = 0;
        for (Integer integer : map.keySet()) {
            if (integer == 1) return -1;
            if (integer == 2) res ++;
            else if (integer % 3 == 0) res += integer / 3;
            else res += integer / 3 + 1;
        }
        return res;
    }
}