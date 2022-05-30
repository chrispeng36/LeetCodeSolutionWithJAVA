package No1022;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/5/30 8:52
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(0);
        TreeNode left2 = new TreeNode(0);
        TreeNode left3 = new TreeNode(1);
        TreeNode right1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(0);
        TreeNode right3 = new TreeNode(1);

        root.left = left1;root.right = right1;
        left1.left = left2;left1.right = left3;
        right1.left = right2;right1.right = right3;
        int i = solution.sumRootToLeaf(root);
        System.out.println(i);
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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int sum){
        if (root == null) return 0;
        sum = 2 * sum + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return helper(root.left, sum) + helper(root.right, sum);
    }
}