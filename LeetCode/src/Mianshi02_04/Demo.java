package Mianshi02_04;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/2/18 9:59
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);

        head.next = node1;node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;
        ListNode head1 = solution.partition(head, 3);
        while (head1 != null){
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){this.val = x;}
    ListNode(int x, ListNode next){this.val = x;this.next = next;}
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}