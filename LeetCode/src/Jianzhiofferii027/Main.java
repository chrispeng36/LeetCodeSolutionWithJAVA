package Jianzhiofferii027;

import java.util.List;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 9/1/2022 3:04 PM
 */
public class Main {
    public static void main(String[] args) {

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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (head != null){
            ListNode node = stack.pop();
            if (head.val != node.val)
                return false;
            head = head.next;
        }
        return true;
    }
}
