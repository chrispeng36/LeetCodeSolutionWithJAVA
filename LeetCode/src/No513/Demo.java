package No513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2021/10/20 18:27
 */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        TreeNode right3 = new TreeNode(7);
        TreeNode right4 = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        right1.right = right4;
        right1.left = right2;
        right2.left = right3;

        Solution solution = new Solution();
        int i = solution.findBottomLeftValue(root);
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()){
            root = queue.poll();
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);
        }
        return root.val;
    }
}