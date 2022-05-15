package No347;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/4/19 21:21
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //根据map的value值正排序，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k)
                queue.poll();
        }
        for (int i = k - 1;i >= 0; i --)
            res[i] = queue.poll().getKey();
        return res;
    }
}
