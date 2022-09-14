package No1302;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ChrisPeng
 * @date 2022/8/17 5:50
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode left3 = new TreeNode(5);
        TreeNode left4 = new TreeNode(7);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(6);
        TreeNode right3 = new TreeNode(8);
        root.left = left1;root.right = right1;
        left1.left = left2;left1.right = left3;
        left2.left = left4;
        right1.right = right2;right2.right = right3;
        Solution solution = new Solution();
        int i = solution.deepestLeavesSum(root);
        System.out.println(i);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (! queue.isEmpty()){
            int size = queue.size();
            int temp_sum = 0;//每一步要清零
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp_sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res = temp_sum;
        }
        return res;
    }
}