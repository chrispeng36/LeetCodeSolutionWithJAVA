package No846;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ChrisPeng
 * @date 2021/12/30 16:35
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        boolean b = solution.isNStraightHand(hand, 3);
        System.out.println(b);
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       int len = hand.length;
       //每组大小为groupsize
        if (len % groupSize != 0)
            return false;
        //排序后将元素出现次数存入哈希表
        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (int num : hand) {
            //由于事先对数组进行排序，所以顺子肯定是连续出现
            if (map.get(num) > 0){
                for (int i = 0; i < groupSize; i++) {
                    //如果连续的数存在，则之前已存入哈希表，消去一次，否则，不是顺子，直接return
                    if (map.get(num + i) != null && map.get(num + i) > 0)
                        map.put(num + i,map.get(num + i) - 1);
                    else
                        return false;
                }
            }
        }
        return true;
    }
}