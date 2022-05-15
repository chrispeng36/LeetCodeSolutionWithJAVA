package No232;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/3/30 0:57
 */
public class Demo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

    }
}

/**
 * 这个类是用栈来模拟队列的操作
 * 栈后进先出
 * 队列先进先出
 */
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<>();//进栈
        stackOut = new Stack<>();//出栈
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dumpStackIn(){
        if (! stackOut.isEmpty()) return;
        while (! stackIn.isEmpty())
            stackOut.push(stackIn.pop());
    }
}

