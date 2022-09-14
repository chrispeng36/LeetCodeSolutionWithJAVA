package No2181;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/12 16:30
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(0);
        head.next = node1;node1.next = node2;node2.next = node3;
        node3.next = node4;node4.next = node5;node5.next = node6;
        node6.next = node7;
        ListNode listNode = solution.mergeNodes(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode();
        ListNode ret = node;
        head = head.next;
        int temp = 0;
        while (head != null){
            if (head.val != 0){
                temp += head.val;
            }else {
                node.next = new ListNode(temp);
                node = node.next;
                temp = 0;
            }
            head = head.next;
        }
        return ret.next;
    }
}