package Jianzhioffer32iii;

import javax.swing.plaf.ProgressBarUI;
import java.util.*;

/**
 * @author ChrisPeng
 * @date 8/26/2022 10:53 AM
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        root.left = left;left.left = left1;
        root.right = right1;right1.right = right2;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            LinkedList<Integer> temp_level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0)
                    temp_level.offerLast(node.val);
                else
                    temp_level.offerFirst(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(temp_level);
            level ++;//for循环一遍后就相当于遍历了一层
        }
        return res;
    }
}