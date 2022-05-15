package No112;

import java.util.*;

/**
 * @author ChrisPeng
 * @date 2022/3/12 22:14
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 3);
        System.out.println(b);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null)
//            return false;
//        if (root.val == targetSum && root.right == null && root.left == null)
//            return true;
//        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
        if (root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);stack2.push(root.val);
        while (! stack1.isEmpty()){
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                Integer sum = stack2.pop();
                //如果是叶子节点，同时该节点路径数值等于sum，返回true
                if (node.left == null && node.right ==null && sum == targetSum) return true;
                //右节点，压进去一个节点的时候，将该节点1的路径数值也记录下来
                if (node.right != null){
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                if (node.left != null){
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }

            }
        }
        return false;
    }
}

