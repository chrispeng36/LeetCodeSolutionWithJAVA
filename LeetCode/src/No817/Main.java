package No817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2022/10/12 9:41
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
    public int numComponents(ListNode head, int[] nums) {
        //链表中一段最长的连续节点的值
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode p = head;
        int count = 0;
        // 链表指针p往后走，当前值在set中，而下一个不在set中 或 到达尾部时，更新count
        while (p != null){
            if (set.contains(p.val) && (p.next == null || !set.contains(p.next.val)))
                count ++;
            p = p.next;
        }
        return count;
    }
}
