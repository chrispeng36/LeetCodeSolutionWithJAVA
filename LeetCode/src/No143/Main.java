package No143;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/7/29 14:59
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
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        /**
         * 1. 找到原链表的中点
         *     使用快慢指针来找到链表的中间节点
         * 2. 将原链表的右半端反转
         *     使用迭代法实现链表的反转
         * 3. 将链表的两端合并
         *     因为两链表长度相差不超过1，因此可以直接合并即可
         */
        if (head == null)
            return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);//将链表的后半段反转
        mergeList(l1, l2);
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表：
     * 首先prev指针初始化为空
     * 当前指针从head开始，用nextTemp记录当前指针的next
     * 不断地将其next赋值为prev
     * 然后就是后移，prev变为cur，cur变为nextTemp
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private void mergeList(ListNode l1, ListNode l2){
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}