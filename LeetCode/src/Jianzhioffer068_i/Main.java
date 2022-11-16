package Jianzhioffer068_i;

/**
 * @author ChrisPeng
 * @date 2022/10/27 11:06
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //找到两个指定节点中的最近公共祖先
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == q || root == p || root == null)
            return root;//后序遍历，先左后右再根
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        /**
         * 如果
         */
        if (left != null && right != null) return root;
        if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else return null;
    }
}