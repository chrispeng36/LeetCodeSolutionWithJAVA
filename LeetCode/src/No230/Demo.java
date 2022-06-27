package No230;

//import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * @author ChrisPeng
 * @date 2021/10/11 15:38
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right1 = new TreeNode(4);

        root.left = left1;
        left1.right = left2;
        root.right = right1;

        Solution solution = new Solution();
        int i = solution.kthSmallest(root, 1);
        System.out.println(i);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        helper(root, stack, k);
        return stack.peek();
    }
    private void helper(TreeNode root, Stack<Integer> stack, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, stack, k);
        if (stack.size() == k) {
            return;
        }
        stack.push(root.val);
        helper(root.right, stack, k);
    }
}