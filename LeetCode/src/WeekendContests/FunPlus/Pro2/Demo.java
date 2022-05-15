package WeekendContests.FunPlus.Pro2;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2022/5/1 11:05
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,4,2,3,4,7};
        int i = solution.minimumCardPickup(arr);
        System.out.println(i);
    }
}

class Solution {
    public int minimumCardPickup(int[] cards) {
        int len = cards.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> orderMap = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (! map.containsKey(cards[i])){
                map.put(cards[i], 1);
                orderMap.put(cards[i], i);//总是保持为最新的
            }
            else {
                map.put(cards[i],map.get(cards[i]) + 1);
                int temp_gap = i - orderMap.get(cards[i]) + 1;
                if (temp_gap < res) res = temp_gap;
                orderMap.put(cards[i], i);//重新更新当前的order
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}