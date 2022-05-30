package Mianshi04_06;

/**
 * @author ChrisPeng
 * @date 2022/5/16 0:38
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        //当前节点值小于等于目标值，那么后继者必然在右子树
        if (p.val >= root.val)
            return inorderSuccessor(root.right, p);
        //否则可能是当前节点或者当前节点的左子树
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}