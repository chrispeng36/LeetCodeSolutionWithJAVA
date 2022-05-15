package No701;

/**
 * @author ChrisPeng
 * @date 2022/3/19 20:59
 */
public class Demo {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //给定二叉搜索树的根节点和要插入的值，将值插入二叉搜索树
        if (root == null) return new TreeNode(val);
        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null){
            pre = root;
            if (root.val > val)
                root = root.left;
            else if (root.val < val)
                root = root.right;
        }
        if (pre.val > val)
            pre.left = new TreeNode(val);
        else
            pre.right = new TreeNode(val);
        return newRoot;
    }
}
