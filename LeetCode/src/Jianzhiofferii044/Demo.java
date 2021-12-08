package Jianzhiofferii044;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2021/10/21 10:19
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(5);
        TreeNode left3 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(9);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = left3;
        right1.right = right2;

        Solution solution = new Solution();
//        ArrayList<Integer> bfs = solution.BFS(root);
//        for (Integer bf : bfs) {
//            System.out.println(bf);
//        }
        List<Integer> integers = solution.largestValues(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}