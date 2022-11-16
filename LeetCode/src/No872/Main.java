package No872;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChrisPeng
 * @date 2022/11/11 9:42
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode left1 = new TreeNode(5);
        TreeNode left2 = new TreeNode(6);
        TreeNode left3 = new TreeNode(2);
        TreeNode left4 = new TreeNode(7);
        TreeNode left5 = new TreeNode(4);
        TreeNode right1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(9);
        TreeNode right3 = new TreeNode(8);
        root1.left = left1;root1.right = right1;
        left1.left = left2;left1.right = left3;
        left3.left = left4;left3.right = left5;
        right1.right = right3;right1.left = right2;

        TreeNode root2 = new TreeNode(3);
        TreeNode left21 = new TreeNode(5);
        TreeNode left22 = new TreeNode(6);
        TreeNode left23 = new TreeNode(7);
        TreeNode right21 = new TreeNode(1);
        TreeNode right22 = new TreeNode(4);
        TreeNode right23 = new TreeNode(2);
        TreeNode right24 = new TreeNode(9);
        TreeNode right25 = new TreeNode(8);
        root2.left = left21;root2.right = right21;
        left21.left = left22;left21.right = left23;
        right21.left = right22;right21.right = right23;
        right23.left = right24;right23.right = right25;

        Solution solution = new Solution();
        boolean b = solution.leafSimilar(root1, root2);
        System.out.println(b);
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String str1 = help(root1, "");
        String str2 = help(root2, "");
        return str1.equals(str2);
    }

    private String help(TreeNode root, String str){
        if (root == null) return str;
        if (root.right == null && root.left == null){
            str += root.val;
        }
        return help(root.left, str) + help(root.right, str);
    }
}