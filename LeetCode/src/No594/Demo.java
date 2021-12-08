package No594;

import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/11/20 0:06
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res,map.get(key) + map.get(key + 1));
        }
        return res;
    }
}