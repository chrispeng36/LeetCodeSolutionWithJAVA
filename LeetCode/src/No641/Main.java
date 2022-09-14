package No641;

/**
 * @author ChrisPeng
 * @date 2022/8/15 11:49
 */
public class Main {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        boolean try1 = circularDeque.insertLast(1);
        System.out.println(try1);
        boolean try2 = circularDeque.insertLast(2);
        System.out.println(try2);
        boolean try3 = circularDeque.insertFront(3);
        System.out.println(try3);
//        System.out.println("此时的size:");
//        System.out.println(circularDeque.size);
        boolean try4 = circularDeque.insertFront(4);
        System.out.println(try4);
//        System.out.println("此时的size:");
//        System.out.println(circularDeque.size);
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        boolean try5 = circularDeque.insertFront(4);
        System.out.println(try5);
        System.out.println(circularDeque.tempSize);
        System.out.println(circularDeque.getFront());
    }
}

class MyCircularDeque {
    //设计实现双端队列
    class Node{
        int val;
        Node prev;
        Node next;

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    private Node first;//头结点
    private Node last;//尾结点
    int size;
    int tempSize;

    public MyCircularDeque(int k) {
        first = null;
        last = null;
        size = k;
        tempSize = 0;
    }

    public boolean insertFront(int value) {
        //将一个元素添加到队列的头部
        if (tempSize >= size){
            //已经塞满了
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()){
            //头结点也就是尾结点
            last = newNode;
        }else {
            first.prev = newNode;
            newNode.next = first;
        }
        first = newNode;
        tempSize ++;
        return true;
    }

    public boolean insertLast(int value) {
        if (tempSize >= size)
            return false;
        Node newNode = new Node(value);
        if (isEmpty()){
            first = newNode;//首节点就是末节点
        }else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        tempSize ++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        Node front = first;
        //首节点后移
        first = first.next;
        if (first == null){
            last = null;
        }else {
            //俩连接都得去除
            first.prev = null;
            front.next = null;
        }
        tempSize --;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        Node back = last;
        last = last.prev;
        if (last == null){
            first = null;
        }else {
            last.next = null;
            back.prev = null;
        }
        tempSize --;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return first.val;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return last.val;
    }

    public boolean isEmpty() {
        return (first == null) && (last == null);
    }

    public boolean isFull() {
        return size == tempSize;
    }
}
