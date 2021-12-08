package No692;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ChrisPeng
 * @date 2021/10/19 12:59
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"i","love","leetcode","i","love","coding"};
        List<String> strings = solution.topKFrequent(arr, 2);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //返回前k个出现次数最多的单词
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i]))
                map.put(words[i],map.get(words[i]) + 1);
            else
                map.put(words[i],1);
        }
        //小顶堆，相同频率下，字母顺序高的在前，方便入栈
        PriorityQueue<String> queue = new PriorityQueue<String>((o1, o2) -> {
            Integer o1Count = map.get(o1);
            Integer o2Count = map.get(o2);
            if (o1Count.equals(o2Count))
                return o2.compareTo(o1);
            else
                return o1Count - o2Count;
        });
        //维持topk频率的单词
        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k)
                queue.poll();
        }
        //利用栈的特性
        LinkedList<String> stack = new LinkedList<>();
        while (! queue.isEmpty())
            stack.push(queue.poll());
        return stack;
    }
}