package No445;

import java.util.List;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 8/29/2022 3:59 PM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head1 = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        head1.next = node1;node1.next = node2;node2.next = node3;
        ListNode head2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        head2.next = node4;node4.next = node5;
        ListNode listNode = solution.addTwoNumbers(head1, head2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> res_stack = new Stack<>();
        while (l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        int extra_add = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode temp1 = stack1.pop();
            ListNode temp2 = stack2.pop();
            int temp_add = temp1.val + temp2.val + extra_add;
            extra_add = 0;
            if (temp_add >= 10){
                extra_add = 1;
                temp_add -= 10;
            }
            ListNode new_node = new ListNode(temp_add);
            res_stack.push(new_node);
        }
        while (! stack1.isEmpty()){
            ListNode temp1 = stack1.pop();
            int temp_add = temp1.val + extra_add;
            extra_add = 0;
            if (temp_add >= 10){
                extra_add = 1;
                temp_add -= 10;
            }
            ListNode new_node = new ListNode(temp_add);
            res_stack.push(new_node);
        }

        while (!stack2.isEmpty()){
            ListNode temp2 = stack2.pop();
            int temp_add = temp2.val + extra_add;
            extra_add = 0;//加完之后进位位就为0
            if (temp_add >= 10){
                extra_add = 1;
                temp_add -= 10;
            }
            ListNode new_node = new ListNode(temp_add);
            res_stack.push(new_node);
        }

        if (extra_add != 0)
            res_stack.push(new ListNode(1));

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!res_stack.isEmpty()){
            temp.next = res_stack.pop();
            temp = temp.next;
        }
        return dummy.next;
    }
}