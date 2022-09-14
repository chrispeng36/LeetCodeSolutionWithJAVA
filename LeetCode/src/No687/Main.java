package No687;

/**
 * @author ChrisPeng
 * @date 9/2/2022 9:34 AM
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
    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if (root == null)
            return 0;
        //对于当前搜索的结点root，分别获取左结点和右节点的最长路径
        int left = dfs(root.left), right = dfs(root.right);
        int left1 = 0, right1 = 0;
        //如果左结点不为空并且左结点的值等于当前节点的值，那么加一
        if (root.left != null && root.left.val == root.val)
            left1 = left + 1;
        if (root.right != null && root.right.val == root.val)
            right1 = right + 1;
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }
}
