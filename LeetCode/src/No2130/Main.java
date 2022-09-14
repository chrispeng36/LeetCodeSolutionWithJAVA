package No2130;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 8/29/2022 7:05 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;node1.next = node2;node2.next = node3;
        int i = solution.pairSum(head);
        System.out.println(i);
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

class Solution{
    public int pairSum(ListNode head){
//        ListNode temp = head;
//        Stack<ListNode> listNodes = new Stack<>();
//        while (temp != null){
//            listNodes.push(temp);
//            temp = temp.next;
//        }
//        int res = 0;
//        while (!listNodes.isEmpty()){
//            int temp_sum = head.val + listNodes.pop().val;
//            if (temp_sum > res)
//                res = temp_sum;
//            head = head.next;
//        }
//        return res;
        LinkedList<ListNode> s = new LinkedList<>();
        int max = 0;
        ListNode p = head;
        ListNode q = head;
        while (p != null){
            if (q != null)
                s.push(p);
            else
                max = Math.max(max, s.pop().val + p.val);
            p = p.next;
            if (q != null){
                q = q.next;
                q = q.next;
            }
        }
        return max;
    }
}