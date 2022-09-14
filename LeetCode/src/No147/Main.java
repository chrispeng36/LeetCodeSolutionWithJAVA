package No147;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/13 9:48
 */
public class Main {
    public static void main(String[] args) {

    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        //对链表执行插入排序
        ListNode dummy = new ListNode(0);
        ListNode pre;
        dummy.next = head;

        while (head != null && head.next != null){
            if (head.val <= head.next.val){
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val < head.next.val)
                pre = pre.next;
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}