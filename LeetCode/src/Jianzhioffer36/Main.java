package Jianzhioffer36;

/**
 * @author ChrisPeng
 * @date 2022/10/11 16:10
 */
public class Main {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node left1 = new Node(2);
        Node left2 = new Node(1);
        Node left3 = new Node(3);
        Node right1 = new Node(5);
        root.left = left1;root.right = right1;
        left1.left = left2;left1.right = left3;
        Solution solution = new Solution();
        Node node = solution.treeToDoublyList(root);
        System.out.println(node.val);
    }
}


class Node{
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        //输入一棵二叉搜索树，将该二叉树转换为一个排序的循环双向链表
        //不能创建任何新的结点，只能调整树中结点指针的指向
        //边界值
        if (root == null) return null;
        dfs(root);
        //题目要求头尾相连
        head.left = pre;
        pre.right = head;
        //返回头结点
        return head;
    }

    /**
     * dfs的基本思想就是从当前节点出发
     * 先遍历到最左边的结点
     * 再对中间节点操作，最后对右子结点操作
     * 设置全局的pre和head指针，pre一直在变化
     * 将当前节点的左子节点设置为pre，pre的右子结点设置为当前节点
     * 可以将递归程序当做状态机来理解
     * @param cur
     */
    private void dfs(Node cur){
        //递归结束条件
        if (cur == null) return;
        dfs(cur.left);//先找到比当前节点小的那个最小的
        //如果pre为空，那就说明是第一个结点，头结点，任何用head保存头结点，用于之后的返回
        if (pre == null) head = cur;
        //如果不为空，那就说明是中间的结点，并且pre保存的是上一个节点
        //让上一个节点的右指针指向当前节点
        else if (pre != null) pre.right = cur;
        cur.left = pre;
        //保存当前节点，用于下层递归的创建
        pre = cur;
        dfs(cur.right);
    }
}