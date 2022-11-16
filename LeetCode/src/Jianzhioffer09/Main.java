package Jianzhioffer09;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/11/16 18:48
 */
public class Main {
    public static void main(String[] args) {

    }
}

class CQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void appendTail(int value) {
        //尾部插入整数
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()){
            if (inStack.isEmpty()) return -1;
            while (! inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }else {
            return outStack.pop();
        }
    }
}

