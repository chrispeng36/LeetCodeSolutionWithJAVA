package No622;

/**
 * @author ChrisPeng
 * @date 2022/8/3 11:28
 */
public class Main {
    public static void main(String[] args) {

    }
}

class MyCircularQueue {
    /**
     * 先入先出的循环列表
     *
     */
    int val[];
    int l, r, k;
    public MyCircularQueue(int k) {
        val = new int[3005];
        l = r = 0;
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (r - l == k)
            return false;
        val[r] = value;
        r ++;
        return true;
    }

    public boolean deQueue() {
        if (l == r)
            return false;
        l ++;
        return true;
    }

    public int Front() {
        return l == r ? -1 : val[l];
    }

    public int Rear() {
        return l == r ? -1 : val[r - 1];
    }

    public boolean isEmpty() {
        return l == r;
    }

    public boolean isFull() {
        return r - l == k;
    }
}