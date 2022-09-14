package No725;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 8/30/2022 1:41 PM
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len ++;
            temp = temp.next;
        }
        int quotient = len / k;
        int remainder = len % k;
        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}