package Jianzhioffer28;

/**
 * @author ChrisPeng
 * @date 2021/10/19 22:30
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode right1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(4);
        TreeNode right3 = new TreeNode(3);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = left3;
        right1.right = right3;
        right1.left = right2;

        Solution solution = new Solution();
        boolean b = solution.isSymmetric(root);
        System.out.println(b);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){this.val = x;}
    TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //树如果存在左右节点，那么左右节点必须相等
//        if (root.left == null && root.right == null)
//            return true;
//        if (root.right == null && root.left != null)
//            return false;
//        if (root.right != null && root.left == null)
//            return false;
//        if (root.right.val != root.left.val)
//            return false;
//        return isSymmetric(root.left) && isSymmetric(root.right);
        if (root == null)
            return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && helper(root1.left,root2.right)&&
                helper(root1.right,root2.left);
    }
}