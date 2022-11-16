package No99;

/**
 * @author ChrisPeng
 * @date 2022/11/8 1:53
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        /**
         * 给定二叉搜索树的根结点root，该树中的恰好两个节点值被错误的交换
         * 不在改变其结构的情况下，恢复这个树
         */
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val){
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}