package Jianzhiofferii029;

/**
 * @author ChrisPeng
 * @date 2022/6/18 10:51
 */
public class Main {
    public static void main(String[] args) {

    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

class Solution {
    public Node insert(Node head, int insertVal) {
        //给定一个循环单调非递减列表中的一个点，插入一个新的元素
         Node cur = null;
         Node next = null;
         Node realHead = null;
         //空的
        if (head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        //找到真正的头结点
        cur = head;
        next = head.next;
        while (cur.val <= next.val){
            cur = cur.next;
            next = next.next;
            if (cur == head) break;
        }
        realHead = next;//指向头结点的下一个
        //找到插入的位置
        while (next.val < insertVal){
            cur = next;
            next = next.next;
            if (next == realHead) break;
        }
        //连接
        cur.next = new Node(insertVal);
        cur = cur.next;
        cur.next = next;
        return head;
    }
}