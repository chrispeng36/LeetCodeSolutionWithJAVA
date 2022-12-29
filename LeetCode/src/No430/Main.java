package No430;

/**
 * @author ChrisPeng
 * @date 2022/11/10 17:01
 */
public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.next = node2;
        node2.prev = node1;node2.next = node3;
        node3.prev = node2;node3.next = node4;node3.child = node7;
        node4.prev = node3;node4.next = node5;
        node5.prev = node4;node5.next = node6;
        node6.prev = node5;
        node7.next = node8;
        node8.prev = node7;node8.next = node9;node8.child = node11;
        node9.prev = node8;node9.next = node10;
        node10.prev = node9;
        node11.next = node12;
        node12.prev = node11;

        Solution solution = new Solution();
        Node flattenNodes = solution.flatten(node1);
        while (flattenNodes != null) {
            System.out.println(flattenNodes.val);
            flattenNodes = flattenNodes.next;
        }
    }
}

class Node{
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(Node prev, Node next, Node child) {
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node cur = node;
        //记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            Node next = cur.next;//找到当前节点的下一个节点，是要为了拼接
            //如果有子结点先处理子结点，当然没有的话就不用修改了
            if (cur.child != null) {
                Node childLast = dfs(cur.child);//对子结点进行dfs，指向子链表的最后一个结点

                next = cur.next;
                //将node与child相连接
                cur.next = cur.child;
                cur.child.prev = cur;

                //如果next不为空，就将last与next相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                //将child置空
                cur.child = null;
                last = childLast;
            }else {
                last = cur;//当前节点没有子结点，那么链表的最后一个结点就是当前节点
            }
            cur = next;
        }
        return last;
    }
}
