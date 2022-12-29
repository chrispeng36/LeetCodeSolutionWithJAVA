package No622;

/**
 * @author ChrisPeng
 * @date 2022/11/16 19:17
 */
public class Main1 {
    public static void main(String[] args) {
        MyCircularQueue1 circularQueue = new MyCircularQueue1(3); // 设置长度为 3
        circularQueue.enQueue(1); // 返回 true
        circularQueue.enQueue(2); // 返回 true
        circularQueue.enQueue(3); // 返回 true
        circularQueue.enQueue(4); // 返回 false，队列已满
        circularQueue.Rear(); // 返回 3
//        circularQueue.isFull(); // 返回 true
//        circularQueue.deQueue(); // 返回 true
//        circularQueue.enQueue(4); // 返回 true
//        circularQueue.Rear(); // 返回 4

    }
}


class MyCircularQueue1 {

    private final int[] arr;
    private final int capacity;
    private int first;
    private int rear;
    private int size;

    public MyCircularQueue1(int k) {
        this.first = 0;
        this.rear = 0;
        this.capacity = k + 1; //预留一个判断队列是否已经满了
        this.arr = new int[capacity];
    }

    public boolean enQueue(int value) {
        /**
         * 加完元素之后如果出现队列是满的情况
         * 我们这里输出的队列尾部就是0处的
         */
        if (isFull()){
            return false;
        }else {//说明还可以加入
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }
    }

    public boolean deQueue() {
        //删除第一个元素
        if (isEmpty()){
            return false;
        }else {
            first = (first + 1) % capacity;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return arr[first];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == first;
    }

    public boolean isFull() {
        return ((rear + 1) % capacity) == first;
    }
}
