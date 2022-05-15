package No637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/7 12:31
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right11 = new TreeNode(20);
        TreeNode right21 = new TreeNode(15);
        TreeNode right22 = new TreeNode(7);

        root.left = left;root.right = right11;
        right11.left = right21;right11.right = right22;
        List<Double> lists = solution.averageOfLevels(root);
        for (Double list : lists) {
            System.out.println(list);
        }
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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            int len = queue.size();
            double sumLevel = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sumLevel += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            double addNum = sumLevel / len;
            res.add(addNum);
        }
        return res;
    }
}