package Mianshi0403;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2021/10/29 12:16
 */
public class Demo {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){this.val = x;}
    TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

/**
 * single-linked list
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x){this.val = x;}
    ListNode(int x , ListNode next){
        this.val = x;
        this.next = next;
    }
}

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        /**
         * 首先使用迭代实现
         */
//        ArrayList<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        ArrayList<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        while(! queue.isEmpty()){
            int curSize = queue.size();
            //dummy节点用来标注头节点
            //curr用来逐个连接新的节点
            ListNode curr = dummy;
            //创建出一个链表和
            for (int i = 0; i < curSize; i++) {
                TreeNode treeNode = queue.poll();
                //连接链表
                curr.next = new ListNode(treeNode.val);
                //将所有节点的左右子节点放到队列中去
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
                curr = curr.next;
            }
            //把这一层的链表头放到返回值中
            res.add(dummy.next);
            dummy.next = null;
        }
        return res.toArray(new ListNode[]{});
    }
}