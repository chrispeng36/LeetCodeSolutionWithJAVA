package No328;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 8/30/2022 10:02 AM
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;node1.next = node2;
        node2.next = node3;node3.next = node4;

        Solution solution = new Solution();
        ListNode list = solution.oddEvenList(head);
        while (list != null){
            System.out.println(list.val);
            list = list.next;
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
    public ListNode oddEvenList(ListNode head) {
        int index = 1;
        ListNode temp = head;
        LinkedList<ListNode> queue1 = new LinkedList<>();
        LinkedList<ListNode> queue2 = new LinkedList<>();
        while (temp != null){
            if (index % 2 == 1)
                queue1.add(temp);
            else
                queue2.add(temp);
            index++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp1 = dummy;
        while (!queue1.isEmpty()){
            temp1.next = queue1.getFirst();
            queue1.removeFirst();
            temp1 = temp1.next;
        }
//        System.out.println(temp1.val);
        while (!queue2.isEmpty()){
            temp1.next = queue2.getFirst();
            queue2.removeFirst();
            temp1 = temp1.next;
        }
        temp1.next = null;
        return dummy.next;
    }
}
