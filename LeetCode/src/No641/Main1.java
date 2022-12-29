package No641;

/**
 * @author ChrisPeng
 * @date 2022/11/17 9:47
 */
public class Main1 {
    public static void main(String[] args) {

    }
}

class MyCircularDeque1 {

    private final int[] arr;
    private final int capacity;
    private int front;
    private int rear;

    public MyCircularDeque1(int k) {
        this.capacity = k + 1;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[capacity];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //还可以在头部插入
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

