package No669;

/**
 * @author ChrisPeng
 * @date 2022/3/22 1:31
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        /**
         * 修剪二叉搜索树
         *
         */
        if (root == null) return null;
        if (root.val < low){
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        if (root.val > high){
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}