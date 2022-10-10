package Jianzhioffer27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 10/6/2022 9:35 AM
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(1);
        TreeNode left3 = new TreeNode(3);
        TreeNode right1 = new TreeNode(7);
        TreeNode right2 = new TreeNode(6);
        TreeNode right3 = new TreeNode(9);
        root.left = left1;left1.left = left2;left1.right = left3;
        root.right = right1;right1.left = right2;right1.right = right3;

        inorder(root);
        TreeNode treeNode = solution.mirrorTree(root);
        System.out.println();
        System.out.println("镜像后：");
        inorder(treeNode);
    }

    public static void inorder(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//删除首元素
                System.out.print(node.val + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
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
    public TreeNode mirrorTree(TreeNode root) {
        //输出二叉树的镜像
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
