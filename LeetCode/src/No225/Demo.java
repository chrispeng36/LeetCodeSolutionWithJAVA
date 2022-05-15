package No225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/30 9:32
 */
public class Demo {
    public static void main(String[] args) {

    }
}

/**
 * 用两个队列来实现栈
 */
class MyStack {
    private Queue<Integer> mainQueue;
    private Queue<Integer> helperQueue;
    public MyStack() {
        mainQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    public void push(int x) {
        helperQueue.offer(x);//先放在辅助队列中
        while (! mainQueue.isEmpty())
            helperQueue.offer(mainQueue.poll());
        Queue<Integer> queueTemp;
        queueTemp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = queueTemp;
    }

    public int pop() {
        return mainQueue.poll();
    }

    public int top() {
        return mainQueue.poll();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
