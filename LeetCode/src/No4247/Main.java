package No4247;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2022/11/27 11:47
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
    public ListNode removeNodes(ListNode head) {
        int[] s = new int[100010];
        int top = -1;
        ListNode temp = head.next;
        s[++top] = head.val;
        while(temp != null){
            while(top != -1 && temp.val > s[top]){
                top--;
            }
            s[++top] = temp.val;
            temp = temp.next;
        }
        int i=0;
        temp = null;
        ListNode p = temp;
        while(head != null){
            if(head.val == s[i]){
                i++;
                if(temp == null){
                    temp = p = head;
                    head = head.next;
                    p.next = null;
                }else{
                    p.next = head;
                    head = head.next;
                    p = p.next;
                    p.next = null;
                }
            }else if(head.val < s[i]) head = head.next;
        }
        return temp;
    }
}
