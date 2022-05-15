package No671;

/**
 * @author ChrisPeng
 * @date 2022/4/13 16:59
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
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null && root.right == null)
            return -1;
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int val){
        if (root.val > val)
            return root.val;
        int left = helper(root.left, val);
        int right = helper(root.right, val);
        if (left > val && right > val)
            return Math.min(left, right);
        return Math.max(left, right);
    }
}