package No92;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/5/8 13:40
 */
public class Demo {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;node1.next = node2;node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        ListNode node = solution.reverseBetween(head, 2, 4);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;//指向当前节点
        ListNode next;//指向下一个节点
        for (int i = 0; i < right - left; i++) {
            next = cur.next;//设置下一个节点
            cur.next = next.next;
            next.next = pre.next;//上面两步交换了
            pre.next = next;
        }
        return dummy.next;
    }
}