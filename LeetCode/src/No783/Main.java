package No783;

import No106.Test;

import java.util.ArrayList;

/**
 * @author ChrisPeng
 * @date 2022/11/19 14:03
 */
public class Main {
    public static void main(String[] args) {

    }
}

class TreeNode {
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

//class Solution {
//    ArrayList<Integer> nodesList;
//    public int minDiffInBST(TreeNode root) {
//        //给定一颗二叉搜索树的根结点root，返回任意两个不同节点之间的最小差值
//        /**
//         * 二叉搜索树：
//         * 若它的左子树不为空，则左子树上所有节点的值都小于根节点的值
//         * 若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
//         */
//        nodesList = new ArrayList<>();
//        int minimum = Integer.MAX_VALUE;
//        dfs(root);
//        for (int i = 1; i < nodesList.size(); i++) {
//            minimum = Math.min(minimum, nodesList.get(i) - nodesList.get(i - 1));
//        }
//        return minimum;
//    }
//
//    private void dfs(TreeNode node) {
//        if (node == null) return;
//        //左中右构成有序的
//        dfs(node.left);
//        nodesList.add(node.val);
//        dfs(node.right);
//    }
//}

class Solution{
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == -1)
            pre = root.val;
        else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}