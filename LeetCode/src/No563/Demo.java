package No563;

/**
 * @author ChrisPeng
 * @date 2021/11/18 8:53
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(5);
        TreeNode right1 = new TreeNode(9);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = left3;
        right1.right = right2;

        Solution solution = new Solution();
        int tilt = solution.findTilt(root);
        System.out.println(tilt);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }
    static int sum(TreeNode root){
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}