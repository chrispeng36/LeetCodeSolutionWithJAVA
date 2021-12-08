package No107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChrisPeng
 * @date 2021/11/29 0:18
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right2 = new TreeNode(15);
        TreeNode right3 = new TreeNode(7);

        root.left = left1;root.right = right1;right1.left = right2;right1.right = right3;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrderBottom(root);
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
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

class Solution {
    /**
     * 二叉树的层序遍历
     * 给定一个二叉树，返回其节点值自底向上的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            ArrayList<Integer> oneLevel = new ArrayList<>();
            //每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //每次都往对头塞
            result.addFirst(oneLevel);
        }
        return result;
    }
}