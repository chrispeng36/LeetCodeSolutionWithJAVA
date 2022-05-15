package No199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/3/6 14:10
 */
public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(5);
        root.right = right1;root.left = left1;
        left1.right = left2;right1.right = right2;

        List<Integer> list = solution.rightSideView(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        /**
         * 给定一个二叉树的根节点，想象站在右侧，按照从顶部到底部的顺序，返回右侧能看到的节点
         */
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
//        res.add(root.val);
        //只有当前根节点的右子节点才能够被看见
        //当当前节点不存在右子节点的时候，才可能会看见左子节点
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (! que.isEmpty()){
            int len = que.size();
            res.add(que.peek().val);
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.right != null) que.add(node.right);
                if (node.left != null) que.add(node.left);
            }
        }
        return res;
    }
}

