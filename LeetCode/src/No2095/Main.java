package No2095;

/**
 * @author ChrisPeng
 * @date 9/2/2022 3:12 PM
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        head.next = node1;node1.next = node2;node2.next = node3;
        node3.next = node4;node4.next = node5;node5.next = node6;

        Solution solution = new Solution();
        ListNode listNode = solution.deleteMiddle(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            dummy = dummy.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        dummy.next = dummy.next.next;
        return head;
    }
}