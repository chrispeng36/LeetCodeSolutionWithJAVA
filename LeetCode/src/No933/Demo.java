package No933;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/5/6 9:30
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        //初始化计数器，请求数为0
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        //在时间t内添加一个新请求，返回过去3000毫秒内发生的所有请求数[t-3000,t]
        queue.offer(t);
        while (queue.peek() < t - 3000)
            queue.poll();
        return queue.size();
    }
}