package No160;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/8/11 1:35
 */
public class Main {
    public static void main(String[] args) {

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}