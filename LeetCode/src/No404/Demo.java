package No404;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/11 13:07
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right2 = new TreeNode(15);
        TreeNode right3 = new TreeNode(7);
        root.left = left;root.right = right1;
        right1.left = right2;right1.right = right3;
        Solution solution = new Solution();
        int i = solution.sumOfLeftLeaves(root);
        System.out.println(i);
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int resSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    if(node.left.left == null && node.left.right == null){
                        resSum += node.left.val;
                    }
                    queue.add(node.left);
                }
                if (node.right != null) queue.add(node.right);
            }
        }
        return resSum;
    }
//    private int postorder(TreeNode root){
//        int sum = 0;
//        if (root == null)
//            return sum;
//        if (root.left != null && root.left.left == null && root.left.right == null)
//            sum += root.left.val;
//        sum += postorder(root.left);
//        sum += postorder(root.right);
//        return sum;
//    }
}

