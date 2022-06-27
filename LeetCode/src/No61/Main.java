package No61;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/6/13 22:26
 */
public class Main {
    public static void main(String[] args) {

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //给定一个链表的头结点，旋转链表
        if (head == null || head.next == null)
            return head;
        if (k == 0) return head;
        ListNode tail = head, newTail = head;
        ListNode newHead;
        int n = 1;
        //原来的尾结点指向原来的头结点，形成环
        while (tail.next != null){
            tail = tail.next;
            n ++;
        }
        tail.next = head;//形成环了
        //找到断开环的位置
        for (int i = 0; i < (n - k % n - 1); i++) {
            newTail = newTail.next;
        }
        //新的头结点指向断开环的位置
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}