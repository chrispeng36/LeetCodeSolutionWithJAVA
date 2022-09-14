package No897;

/**
 * @author ChrisPeng
 * @date 9/2/2022 5:19 PM
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
    public TreeNode increasingBST(TreeNode root) {
        //按照右中左的顺序来遍历
        reverseInorder(root);
        return preNode;
    }

    private void reverseInorder(TreeNode root){
        if (root == null)
            return;
        //遍历右子结点
        reverseInorder(root.right);
        //遍历根结点
        root.right = preNode;
        preNode = root;
        //遍历左子树
        reverseInorder(root.left);
        //置空左子树
        root.left = null;
    }
}