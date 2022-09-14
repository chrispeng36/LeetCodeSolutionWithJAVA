package No814;

import com.sun.source.tree.Tree;

/**
 * @author ChrisPeng
 * @date 2022/7/21 10:14
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
    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        //返回移除了所有不包含1的子树的原二叉树
        //只有当递归完成时，左子树为空，右子树为空，当前节点为0时删除
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        return root;
    }
}