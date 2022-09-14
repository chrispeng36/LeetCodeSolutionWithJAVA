package Mianshi17_12;

/**
 * @author ChrisPeng
 * @date 9/1/2022 7:18 PM
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
    TreeNode preNode;
    public TreeNode convertBiNode(TreeNode root) {
        reverseInorder(root);
        return preNode;
    }
    private void reverseInorder(TreeNode root){
        if (root == null)
            return;
        //遍历右子树
        reverseInorder(root.right);
        //遍历根结点
        root.right = preNode;
        preNode = root;
        //遍历左子树
        reverseInorder(root.left);
        //置空左指针
        root.left = null;
    }
}
