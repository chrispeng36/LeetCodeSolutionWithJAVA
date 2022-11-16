package Jianzhioffer55_ii;

/**
 * @author ChrisPeng
 * @date 2022/10/18 15:24
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode{
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
    public boolean isBalanced(TreeNode root) {
        /**
         * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
         * 如果某二叉树中任意节点的左右子树的深度相差不超过1，
         * 那么它就是一棵平衡二叉树。
         */
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        return false;
    }

    private int getHeight(TreeNode root){
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
