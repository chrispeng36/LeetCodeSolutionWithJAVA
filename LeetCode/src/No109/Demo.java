package No109;

import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/11/25 13:11
 * 有序链表转换为高度平衡的二叉搜索树
 */
public class Demo {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode next1 = new ListNode(-3);
        ListNode next2 = new ListNode(0);
        ListNode next3 = new ListNode(5);
        ListNode next4 = new ListNode(9);
        head.next = next1;next1.next = next2;next2.next = next3;next3.next = next4;

        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedListToBST(head);

        preOrder(treeNode);
    }
    static void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.val + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        /**
         * 高度平衡二叉树是指一颗二叉树每个节点的左右子树的高度差的绝对值不超过1
         * 二叉搜索树：
         * 左子树的值不大于节点
         * 右子树的值不小于节点
         */
        /**
         * 链表查找中间点的方法是通过快慢指针的，
         * 找到中点之后，以中点的值建立一个数的根节点，然后需要把原链表断开
         * 分为前后两个链表，都不能包含中点
         * 然后分别对这两个链表递归调用原函数，分别链接左右子节点即可
         */

        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode last = head;
        while (fast.next != null && fast.next.next != null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        last.next = null;
        TreeNode cur = new TreeNode(slow.val);
        if (head != slow) cur.left = sortedListToBST(head);
        cur.right = sortedListToBST(fast);

        return cur;
    }
}

