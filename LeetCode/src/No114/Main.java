package No114;

/**
 * @author ChrisPeng
 * @date 2022/8/1 10:57
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        //给定一个二叉树的根结点，展开成单链表
        //链表使用TreeNode，right指向下一个节点，左子指针指向null
        //展开后的单链表与先序遍历顺序相同
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}